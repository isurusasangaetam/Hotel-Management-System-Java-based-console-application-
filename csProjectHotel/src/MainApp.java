import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainApp {
    private static ArrayList<Guest> guestList = new ArrayList<>(); // List to store all guests

    public static void main(String[] args) {
        HotelManagement hotelManagement = new HotelManagement();
        hotelManagement.getRooms().add(new StandardRoom(101, 100.0, true));
        hotelManagement.getRooms().add(new DeluxeRoom(201, 200.0, true));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHotel Management System");
            System.out.println("1. Add Guest");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Check In Guest");
            System.out.println("4. Check Out Guest");
            System.out.println("5. Calculate Bill");
            System.out.println("6. Exit");
            choice = getValidIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    // Add Guest
                    System.out.print("Enter Guest Name: ");
                    String name = scanner.next();
                    String guestId = GuestUtils.generateGuestId();  // Generate Guest ID
                    System.out.println("Generated Guest ID: " + guestId);
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    Guest guest = new Guest(name, guestId, contactNumber, email);
                    guestList.add(guest);  // Add the new guest to the list
                    FileUtils.writeToFile("GuestDetails.txt", "Added Guest: " + guest);
                    System.out.println("Guest added: " + guest);
                    break;

                case 2:
                    // Check Room Availability
                    System.out.print("Enter Room Type (Standard/Deluxe): ");
                    String roomType = scanner.next();
                    Room availableRoom = hotelManagement.findAvailableRoom(roomType);
                    System.out.println(availableRoom != null ? availableRoom : "No rooms available.");
                    break;

                case 3:
                    // Check In Guest
                    // Display all guests before asking for Guest ID
                    System.out.println("\nList of Guests:");
                    for (Guest g : guestList) {
                        System.out.println(g);
                    }

                    // Ask for Guest ID
                    System.out.print("\nEnter Guest ID for check-in: ");
                    String checkInGuestId = scanner.next();  // Ask for Guest ID

                    // Search for the guest by ID
                    Guest checkInGuest = findGuestById(checkInGuestId);
                    if (checkInGuest == null) {
                        System.out.println("Guest with ID " + checkInGuestId + " not found.");
                        break;
                    }

                    System.out.println("Guest Found: " + checkInGuest);  // Show found guest details

                    System.out.print("Enter Room Type (Standard/Deluxe): ");
                    String checkInRoomType = scanner.next();
                    Room roomToCheckIn = hotelManagement.findAvailableRoom(checkInRoomType);
                    if (roomToCheckIn != null) {
                        hotelManagement.checkInGuest(checkInGuest, roomToCheckIn);
                        FileUtils.writeToFile("GuestDetails.txt", "Checked In: " + checkInGuest + " to Room " + roomToCheckIn);
                    } else {
                        System.out.println("No available rooms for check-in.");
                    }
                    break;

                case 4:
                    // Check Out Guest
                    int roomNumber = getValidIntInput(scanner, "Enter Room Number for Check-Out: ");
                    Room roomToCheckOut = null;
                    for (Room room : hotelManagement.getRooms()) {
                        if (room.getRoomNumber() == roomNumber) {
                            roomToCheckOut = room;
                            break;
                        }
                    }
                    if (roomToCheckOut != null && !roomToCheckOut.isAvailable()) {
                        hotelManagement.checkOutGuest(roomToCheckOut);
                        FileUtils.writeToFile("GuestDetails.txt", "Checked Out from Room " + roomToCheckOut.getRoomNumber());
                    } else {
                        System.out.println("Invalid room number or room already available.");
                    }
                    break;

                case 5:
                    // Calculate Bill
                    int billRoomNumber = getValidIntInput(scanner, "Enter Room Number: ");
                    int nights = getValidIntInput(scanner, "Enter Number of Nights: ");

                    Room billRoom = null;
                    for (Room room : hotelManagement.getRooms()) {
                        if (room.getRoomNumber() == billRoomNumber) {
                            billRoom = room;
                            break;
                        }
                    }

                    if (billRoom != null) {
                        double bill = hotelManagement.calculateBill(billRoom, nights);
                        System.out.println("Total Bill: $" + bill);

                        // Ask for receipt
                        System.out.print("Do you want a receipt? (yes/no): ");
                        String receiptChoice = scanner.next();
                        if (receiptChoice.equalsIgnoreCase("yes")) {
                            System.out.print("Enter Guest Name for the Receipt: ");
                            String billGuestName = scanner.next();
                            Guest billGuest = new Guest(billGuestName, "999", "9999999999", "guest@bill.com");
                            String receipt = "Guest: " + billGuest.getName() +
                                    "\nRoom Number: " + billRoom.getRoomNumber() +
                                    "\nRoom Type: " + billRoom.getRoomType() +
                                    "\nNights: " + nights +
                                    "\nTotal Bill: $" + bill +
                                    "\n-----------------------------";
                            FileUtils.writeToFile("GuestBill_" + billGuestName + ".txt", receipt);
                        }
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Utility method to validate integer input
    public static int getValidIntInput(Scanner scanner, String message) {
        int input;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                return input; // Return valid input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    // Method to search for a guest by ID
    public static Guest findGuestById(String guestId) {
        for (Guest guest : guestList) {
            if (guest.getId().equals(guestId)) {
                return guest;
            }
        }
        return null; // Guest not found
    }
}