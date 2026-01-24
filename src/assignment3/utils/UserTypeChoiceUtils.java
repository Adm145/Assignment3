package assignment3.utils;
import java.util.Scanner;

public class UserTypeChoiceUtils {
    //O(k)
    public static boolean setIsRealtor(Scanner input) {
        System.out.println("\nWould you like to register as a realtor? (y/n)");
        boolean isRealtor = false;
        boolean validInput = false;
        while (!validInput) {
            String isRealtorInput = input.next();
            if (isRealtorInput.equalsIgnoreCase("y")) {
                isRealtor = true;
                validInput = true;
            } else if (isRealtorInput.equalsIgnoreCase("n")) {
                validInput = true;
                continue;
            }
            if (!validInput) {
                System.out.println("Invalid input, Please try again and make sure to enter a correct input");
                System.out.println("y - to register as a realtor OR n - to register as a regular user");
            }
        }
        return isRealtor;
    }
}
