package assignment3.utils;
import java.util.Scanner;

import assignment3.User;

public class UsernameAvailabilityValidator {
    //O(n * k)
    public static String setUserName(Scanner input, User[] users) {
        String userName = "";
        boolean userNameTaken = true;
        System.out.println("Enter desired username:");
        for (; true ;) {
            userName = input.next();
            userNameTaken = isUserNameTaken(userName, users);
            if (!userNameTaken) {
                break;
            } else {
                System.out.println("Username already taken. Please choose a different username.");
            }
        }
        return userName;
    }
    //O(n)
    private static boolean isUserNameTaken(String userName, User[] users) {
        for(int i = 0; i < users.length; i++) {
            if(users[i].getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
