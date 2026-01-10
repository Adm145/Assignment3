package utils;
import java.util.Scanner;


public class MenuUtils {
    public static int getMainMenuChoice(Scanner input, RealEstate app) {
        System.out.println("Welcome to the Real Estate Application!");
        System.out.println("Would you like to log in or sign up?");
        System.out.println("(1 - Create an account, 2 - Log in, 3 - end program)");
        
        int choice = -1;
        boolean validChoice = false;
        for (;!validChoice;) {
            choice = input.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        return choice;
    }

    public static int getSecondaryMenuChoice(Scanner input) {
        int choice = -1;
        boolean validChoice = false;
        for (;!validChoice;) {
            choice = input.nextInt();
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, 3, 4, or 5.");
            }
        }
        return choice;
    }
}
