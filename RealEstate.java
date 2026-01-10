import java.util.Scanner;

import utils.PasswordValidatorUtils;
import utils.PhoneNoValidatorUtils;

public class RealEstate {
    private Property[] properties;
    private User[] users;
    private City[] cities;

    public RealEstate() {
        this.properties = new Property[5];
        this.users = new User[0];
        this.cities = new City[10];
    }

    //user signup
    public boolean createUser(Scanner input) {
        //username
        String userName = "";
        boolean userNameTaken = true;
        System.out.println("Enter desired username:");
        for (; true ;) {
            userName = input.next();
            userNameTaken = isUserNameTaken(userName);
            if (!userNameTaken) {
                break;
            } else {
                System.out.println("Username already taken. Please choose a different username.");
            }
        }
        //password
        String password = "";
        boolean passwordValid = false;
        for (; !passwordValid ;) {
            password = input.next();
            passwordValid = PasswordValidatorUtils.isPasswordValid(password);
            if (!passwordValid) {
                System.out.println("Password must be at least 5 characters long.");
                System.out.println("Please enter a valid password:");
            } else {
                break;
            }
        }
        //phone number
        String phoneNo = "";
        boolean phoneNoValid = false;
        System.out.println("Enter your phone number:");
        for (; !phoneNoValid ;) {
            phoneNo = input.next();
            phoneNoValid = PhoneNoValidatorUtils.isPhoneNoValid(phoneNo);
            if (!phoneNoValid) {
                System.out.println("Phone number must be 10 digits long, contain only digits, and start with '05'.");
                System.out.println("Please enter a valid phone number:");
            } else {
                break;
            }
        }
        //realtor status
        System.out.println("Would you like to register as a realtor? (true/false)");
        boolean isRealtor = input.nextBoolean();

        //create user and add to users array
        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = this.users[i];
        }
        User u = new User(userName, password, phoneNo, isRealtor);
        temp[this.users.length] = u;
        this.users = temp;
        return true;
    }

    // username availability check
    private boolean isUserNameTaken(String userName) {
        for(int i = 0; i < users.length; i++) {
            if(users[i].getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    //user login
    public User userLogin(Scanner input) {
        String userName = input.next();
        String password = input.next();
        for (int i = 0; i < this.users.length; i++) {
            if (users[i].getUserName().equals(userName) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    // private void 
}
