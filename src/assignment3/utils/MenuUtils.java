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
                    System.out.println("Would you like to log in to your new account? (t/f).");
                    boolean validInput = false;
                    while (!validInput) {
                        String loginNow = input.next();
                        if (loginNow.equalsIgnoreCase("t")) {
                            loginUser(input, app);
                            validInput = true;
                        } else if (loginNow.equalsIgnoreCase("f")) {
                            validInput = true;
                        } else {
                            System.out.println("Invalid input. Please enter 't' or 'f'.");
                        }
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
        boolean validInput = false;
        for (;!validInput;) {
            int userChoice = input.nextInt();
            if (userChoice == 1) {
                boolean result = app.postNewProperty(loggedUser ,input);
                if (result) {
                    System.out.println("\nProperty advertised successfully by : " + loggedUser.getUserName());
                    validInput = true;
                } else {
                    System.out.println("\nFailed to advertise property.");
                    System.out.println("Please ensure you meet all the requirements and try again.");
                }
            } else if (userChoice == 2) {
                //todo remove property advertisement
                app.removeProperty(loggedUser, input);
            } else if (userChoice == 3) {
                app.printAllProperties();
            } else if (userChoice == 4) {
                app.printPropertiesByUser(loggedUser);
            } else if (userChoice == 5) {
                app.search(input);
            } else if (userChoice == 6) {
                //! log out and return to main menu
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, 3, 4, 5, or 6.");
            }
        }
    }   
}
