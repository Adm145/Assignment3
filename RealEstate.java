public class RealEstate {
    private Property[] properties;
    private User[] users;
    private City[] cities;

    public RealEstate() {}

    public void createUser(String userName, String password, String phoneNo, boolean isRealtor) {
        User newUser = new User(userName, password, phoneNo, isRealtor);
        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = this.users[i];
        }
        temp[this.users.length] = newUser;
        this.users = temp;

    }
}
