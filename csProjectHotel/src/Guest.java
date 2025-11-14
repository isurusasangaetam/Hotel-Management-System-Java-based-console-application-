public class Guest {
    private String name;
    private String id;
    private String contactNumber;
    private String email;

    // Constructor
    public Guest(String name, String id, String contactNumber, String email) {
        this.name = name;
        this.id = id;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getId() { return id; }

    // toString Method
    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
