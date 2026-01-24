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
    //O(1)
    public String getPropertyPoster() {
        return this.userPosted.getUserName();
    }
    //O(1)
    public int getPropertyId() {
        return this.id;
    }
    //O(1)
    public String getPropertyStatus() {
        if (this.isForRent) {
            return "Rent";
        } else {
            return "Sale";
        }
    }
    //O(1)
    public String getPropertyType() {
        return this.propertyType;
    }
    //O(1)
    public int getAmountOfRooms() {
        return amountOfRooms;
    }
    //O(1)
    public int getPrice() {
        return this.price;
    }
    //O(n)
    private String getPriceFormat() {
        String price = this.price + "";
        String formattedPrice = "";
        int count = 0;
        for (int i = price.length() - 1; i >= 0; i--) {
            formattedPrice = price.charAt(i) + formattedPrice;
            count++;

            if (count % 3 == 0) {
                formattedPrice = "," + formattedPrice;
            }
        }
        return formattedPrice;
    }
    //O(1)
    private String userTypeText() {
        if (this.userPosted.getIsRealtor()) {
            return "(real estate broker)";
        }
        return "(not a real estate broker)";
    }
    //O(1)
    public String toString() {
        return "\n" + this.city + " - " + this.street + " " + this.houseNumber + ".\n" +
               "Price: " + getPriceFormat() + "$\n" +
               "A nice " + this.propertyType + " - for " + this.getPropertyStatus() + ": " + this.amountOfRooms + " rooms, " + "floor " + this.floor + ".\n" +
               "Contact Info: " + this.userPosted.getUserName()+ " " + this.userPosted.getPhoneNo() + " " + this.userTypeText() + ".\n";
    }
}
