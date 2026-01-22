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

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public boolean getIsRealtor() {
        return this.isRealtor;
    }

    public int getAdvertisedProperties() {
        return this.advertisedProperties;
    }
    public void incrementAdvertisedProperties() {
        this.advertisedProperties++;
    }

    public boolean canAdvertiseMore() {
        return this.advertisedProperties < this.adLimit;
    }
}
