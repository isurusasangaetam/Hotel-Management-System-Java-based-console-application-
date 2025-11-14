public class Booking {
    private int bookingId;
    private String checkInDate;
    private String checkOutDate;
    private String roomType;

    // Constructor
    public Booking(int bookingId, String checkInDate, String checkOutDate, String roomType) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
    }

    // toString Method
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
