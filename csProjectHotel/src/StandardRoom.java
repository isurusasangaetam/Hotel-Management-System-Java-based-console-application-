public class StandardRoom extends Room {

    public StandardRoom(int roomNumber, double price, boolean isAvailable) {
        super(roomNumber, "Standard", price, isAvailable);
    }

    @Override
    public double calculateRate() {
        return price; // Calculate rate based on the base price
    }
}
