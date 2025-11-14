# Project Report: Hotel Management System

## 1. Project Overview

The **Hotel Management System (HMS)** is a Java-based console application designed to manage hotel operations, such as adding guests, checking room availability, managing check-ins and check-outs, and calculating bills. The system provides a user-friendly interface to manage hotel guest data and rooms, enabling staff to interact with the system and perform necessary tasks efficiently.

## 2. Project Objectives

- **Guest Management**: The system allows for adding and managing guest information, including generating unique guest IDs automatically based on the date and sequential number.
- **Room Management**: The system tracks room availability, with the ability to add rooms and check their availability by room type.
- **Check-in and Check-out**: The system facilitates guest check-in and check-out processes, updating room status accordingly.
- **Billing**: The system calculates and generates bills for guests based on the duration of their stay.
- **Reports**: The system generates simple reports like guest details, room availability, and billing information. The data is saved to text files for records and review.

## 3. Key Features

- **Guest Registration**:  
  - Guests are registered with details like name, contact information, and a unique ID.  
  - The unique ID is generated based on the current date and a sequential number (e.g., dd.MM.yy.θθ1).

- **Room Management**:  
  - Users can add rooms and check for room availability.  
  - Rooms are categorized into standard and deluxe types.  
  - Each room has attributes like room number, room type, price, and availability status.

- **Check-in/Check-out Management**:  
  - The system allows users to check in guests by searching for the guest ID.  
  - On check-out, the room’s availability is updated.

- **Billing**:  
  - The system calculates the total bill based on the room type and the number of nights stayed.  
  - Bills are optionally printed as a receipt and saved to a file.

- **File Reporting**:  
  - Guest information, check-in/check-out records, and billing details are saved in text files for easy tracking.

- **Error Handling**:  
  - The system handles invalid inputs using exceptions, prompting users to re-enter correct values when necessary.

## 4. System Design

The system consists of the following components:

- **Classes**:
  1. **Guest**: Stores guest information such as name, guest ID, contact number, and email.
  2. **Room** (abstract class): Represents a room, with attributes like room number, room type, price, and availability status.
  3. **StandardRoom** and **DeluxeRoom**: Specific room types extending the Room class, each with additional features.
  4. **HotelManagement**: Handles operations like check-in, check-out, finding available rooms, and calculating bills.
  5. **MainApp**: The main entry point of the application, handling user interaction and menu-driven operations.
  6. **FileUtils**: Handles reading from and writing to text files for reporting purposes.
  7. **GuestUtils**: Responsible for generating unique guest IDs based on the current date and sequential number.

## 5. Detailed Functionality

### Add Guest

- When a guest is added, the system automatically generates a unique guest ID in the format `dd.MM.yy.xxx`.
- The system prompts the user for necessary details like name, contact number, and email.

### Room Availability

- The user can check room availability by specifying the room type (Standard/Deluxe).
- Available rooms are displayed with details including room number, type, and price.

### Check-in Guest

- Before check-in, the system lists all guests.
- The user is prompted to select a guest by entering their **Guest ID**.
- Once the guest is identified, the system checks room availability and assigns the guest to an available room.

### Check-out Guest

- The user inputs the room number for check-out.
- The system updates the room's availability to reflect that the room is now vacant.

### Calculate Bill

- The system calculates the bill based on the number of nights stayed and room type.
- After calculating the bill, the system asks if the user wants a receipt. If yes, the receipt is saved to a file.

### Reporting

- **Guest Details**: A list of all guests is stored in a file (`GuestDetails.txt`), including any actions like adding, checking in, and checking out.
- **Billing Details**: A detailed receipt is optionally generated and saved to a file when a guest checks out.

## 6. Data Flow Diagram

### 1. Guest Management:

- **Input**: Name, Contact, Email  
- **Process**: Generate Guest ID, Add Guest to List  
- **Output**: Guest ID, Guest Information  

### 2. Room Availability:

- **Input**: Room Type  
- **Process**: Search for Available Rooms  
- **Output**: Available Room Information  

### 3. Check-In:

- **Input**: Guest ID, Room Type  
- **Process**: Find Guest by ID, Assign Room  
- **Output**: Updated Room Availability, Guest Assignment  

### 4. Check-Out:

- **Input**: Room Number  
- **Process**: Update Room Availability  
- **Output**: Room Available for New Guest  

### 5. Billing:

- **Input**: Room Type, Number of Nights  
- **Process**: Calculate Bill, Ask for Receipt  
- **Output**: Receipt (if requested)  

## 7. User Interface (UI)

The UI is based on console input/output with a menu system. The user interacts with the system by selecting options from the menu, entering information like guest names, room types, and room numbers, and viewing results in the console.

- **Main Menu**:
  - Option 1: Add Guest
  - Option 2: Check Room Availability
  - Option 3: Check In Guest
  - Option 4: Check Out Guest
  - Option 5: Calculate Bill
  - Option 6: Exit

Each option prompts the user for further input and displays relevant results.

## 8. Example Use Cases

1. **Adding a Guest**:
   - User enters the guest's name, contact number, and email.
   - The system generates a unique guest ID (e.g., `81.11.23.081`) and adds the guest to the list.

2. **Checking Room Availability**:
   - User enters room type (Standard or Deluxe).
   - The system returns available rooms with their details.

3. **Checking in a Guest**:
   - User selects a guest from the list (after viewing all guests).
   - The system assigns an available room to the guest.

4. **Check-Out Process**:
   - User enters the room number for check-out.
   - The system marks the room as available again.

5. **Bill Calculation and Receipt**:
   - User enters the room number and the number of nights stayed.
   - The system calculates the bill and asks if the user wants a receipt.

## 9. Future Enhancements

- **Graphical User Interface (GUI)**: The current system operates via the command line, but a graphical interface could be implemented to make the user experience more intuitive.
- **Database Integration**: Instead of storing data in text files, a relational database could be used for better data management, security, and scalability.
- **Advanced Reporting**: Detailed reports, such as monthly earnings, occupancy rates, and more, can be generated.
- **Payment Integration**: Integration with payment systems for automatic bill payments during check-out.

## 10. Conclusion

The **Hotel Management System** project provides a simple, yet functional solution for managing hotel operations. It demonstrates how Java can be used to manage and organize complex systems, providing useful features like guest management, room availability tracking, check-in/check-out functionality, and billing. The project is extendable and can be enhanced with additional features and a more sophisticated user interface.
