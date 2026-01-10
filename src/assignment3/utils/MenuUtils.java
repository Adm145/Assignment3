package assignment3.utils;
import java.util.Scanner;
import assignment3.RealEstate;
import assignment3.User;


public class MenuUtils {
    public static void mainMenu(Scanner input, RealEstate app) {
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.println("Welcome to the Real Estate Application!");
            System.out.println("Would you like to log in or sign up?");
            System.out.println("(1 - Create an account, 2 - Log in, 3 - end program)");

            int choice = input.nextInt();
            if (choice == 1) {
                if (app.createUser(input)) {
                    System.out.println("User created successfully.");
                    System.out.println("Would you like to log in to your new account? (true/false).");
                    boolean loginNow = input.nextBoolean();
                    if (loginNow) {
                        loginUser(input, app);
                    } else {
                        System.out.println("Returning to main menu.");
                    }
                }
            } else if (choice == 2) {
                loginUser(input, app);
            } else if (choice == 3) {
                System.out.println("Thank you for using the Real Estate Application. Goodbye!");
                exitProgram = true;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }       
    }
    
    private static void loginUser(Scanner input, RealEstate app) {
        User loggedUser = app.userLogin(input);
        if (loggedUser == null) {
            System.out.println("Invalid username or password, please try again.");
        } else {
            System.out.println("Login successful! Welcome, " + loggedUser.getUserName() + "!");
            secondaryMenu(input, loggedUser, app);
        }
    }

    public static void secondaryMenu(Scanner input, User loggedUser, RealEstate app) {
        System.out.println(
            "\n" + "Please choose an option:" + "\n" +
            "1 - Advertise a new property" + "\n" +
            "2 - Remove property advertisement" + "\n" +
            "3 - Display all properties" + "\n" +
            "4 - Display all properties advertised by you" + "\n" +
            "5 - Search for a property" + "\n" +
            "6 - Log out and return to main menu" + "\n" +
            "Enter your choice (1-6):"
        );
        boolean validChoice = false;
        for (;!validChoice;) {
            int choice = input.nextInt();
            if (choice == 1) {
                boolean result = app.postNewProperty(loggedUser ,input);
            } else if (choice == 2) {
                //remove property advertisement
            } else if (choice == 3) {
                //display all properties
            } else if (choice == 4) {
                //display all properties advertised my logged in user
            } else if (choice == 5) {
                //filter properties by parameters
            } else if (choice == 6) {
                //log out and return to main menu
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, 3, 4, or 5.");
            }
        }
    }   
}
