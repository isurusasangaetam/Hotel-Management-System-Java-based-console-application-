public interface HotelOperations {
    void checkInGuest(Guest guest, Room room);
    void checkOutGuest(Room room);
    Room findAvailableRoom(String roomType);
    double calculateBill(Room room, int nights);
}
