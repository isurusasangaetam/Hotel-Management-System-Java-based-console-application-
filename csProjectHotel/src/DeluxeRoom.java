public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, double price, boolean isAvailable) {
        super(roomNumber, "Deluxe", price, isAvailable);
    }

    @Override
    public double calculateRate() {
        return price; // Calculate rate based on the base price
    }
}
