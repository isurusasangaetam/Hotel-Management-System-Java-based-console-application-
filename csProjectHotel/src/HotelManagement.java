import java.util.ArrayList;

public class HotelManagement implements HotelOperations {
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public HotelManagement() {
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public void checkInGuest(Guest guest, Room room) {
        if (room.isAvailable()) {
            room.setAvailable(false);
            System.out.println(guest.getName() + " checked into room " + room.getRoomNumber());
        } else {
            System.out.println("Room is not available!");
        }
    }

    @Override
    public void checkOutGuest(Room room) {
        room.setAvailable(true);
        System.out.println("Room " + room.getRoomNumber() + " is now available.");
    }

    @Override
    public Room findAvailableRoom(String roomType) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomType().equalsIgnoreCase(roomType)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public double calculateBill(Room room, int nights) {
        return room.calculateRate() * nights;
    }
}
