public class User {
    private String userName;
    private String password;
    private String phoneNo;
    private boolean isRealtor;

    public User(String userName, String password, String phoneNo, boolean isRealtor) {
        this.userName = userName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.isRealtor = isRealtor;
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
}
