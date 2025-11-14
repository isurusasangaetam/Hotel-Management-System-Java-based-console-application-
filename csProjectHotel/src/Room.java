public abstract class Room {
    protected int roomNumber;
    protected String roomType;
    protected double price;
    protected boolean isAvailable;

    // Constructor
    public Room(int roomNumber, String roomType, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Abstract Method
    public abstract double calculateRate();

    // Getters and Setters
    public int getRoomNumber() { return roomNumber; }

    public String getRoomType() { return roomType; }

    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { isAvailable = available; }

    // toString Method
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
