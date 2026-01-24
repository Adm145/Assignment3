package assignment3;
public class User {
    private String userName;
    private String password;
    private String phoneNo;
    private boolean isRealtor;
    private int advertisedProperties;
    private int adLimit;

    public User(String userName, String password, String phoneNo, boolean isRealtor) {
        this.userName = userName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.isRealtor = isRealtor;
        this.advertisedProperties = 0;
        if (isRealtor) {
            this.adLimit = 5;
        } else {
            this.adLimit = 2;
        }
    }
    //O(1)
    public String getUserName() {
        return this.userName;
    }
    //O(1)
    public String getPassword() {
        return this.password;
    }
    //O(1)
    public String getPhoneNo() {
        return this.phoneNo;
    }
    //O(1)
    public boolean getIsRealtor() {
        return this.isRealtor;
    }
    //O(1)
    public int getAdvertisedProperties() {
        return this.advertisedProperties;
    }
    //O(1)
    public void incrementAdvertisedProperties() {
        this.advertisedProperties++;
    }
    //O(1)
    public boolean canAdvertiseMore() {
        return this.advertisedProperties < this.adLimit;
    }
}
