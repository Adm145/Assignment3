package assignment3;
public class Property {
    private static int nextId = 1;


    private String city;
    private String street;
    private String propertyType;
    private int floor;
    private int amountOfRooms;
    private int price;
    private boolean isForRent;
    private int houseNumber;
    private User userPosted;
    private int id;

    public Property(String city, String street, int amountOfRooms, int price, String propertyType, boolean isForRent, int houseNumber, int floor, User userPosted) {
        this.id = nextId;
        nextId++;

        this.city = city;
        this.street = street;
        this.propertyType = propertyType;
        this.floor = floor;
        this.amountOfRooms = amountOfRooms;
        this.price = price;
        this.isForRent = isForRent;
        this.houseNumber = houseNumber;
        this.userPosted = userPosted;
    }
    
    public String getPropertyPoster() {
        return this.userPosted.getUserName();
    }

    public int getPropertyId() {
        return this.id;
    }

    public String getPropertyStatus() {
        if (this.isForRent) {
            return "Rent";
        } else {
            return "Sale";
        }
    }

    public String getPropertyType() {
        return this.propertyType;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    public int getPrice() {
        return this.price;
    }

    private String userTypeText() {
        if (this.userPosted.getIsRealtor()) {
            return "(real estate broker)";
        }
        return "(not a real estate broker)";
    }


    public String toString() {
        return this.city + " - " + this.street + " " + this.houseNumber + ".\n" +
               "A nice " + this.propertyType + " - for" + this.getPropertyStatus() + ": " + this.amountOfRooms + " rooms, " + "floor " + this.floor + ".\n" +
               "Contact Info: " + this.userPosted.getUserName() + this.userPosted.getPhoneNo() + this.userTypeText();
    }
}
