package assignment3.utils;
import java.util.Scanner;

public class PasswordValidatorUtils {

    public static String setPassword(Scanner input) {
        String password = "";
        boolean passwordValid = false;
        for (; !passwordValid ;) {
            System.out.println("Enter password:");
            password = input.next();
            passwordValid = isPasswordValid(password);
            if (!passwordValid) {
                System.out.println("Password must be at least 5 characters long, contain at least one digit, and contain at least one special character ($, %, _).");
                System.out.println("Please enter a valid password:");
            } else {
                break;
            }
        }
        return password;
    }

    private static boolean isPasswordValid(String password) {
        boolean lengthValid = isPasswordLengthValid(password);
        boolean containsDigit = doesPasswordContainDigit(password);
        boolean containsSpecialChar = doesPasswordContainSpecialChar(password);
        if (lengthValid && containsDigit && containsSpecialChar) {
            return true;
        }
        return false;
    }

    private static boolean isPasswordLengthValid(String password) {
        if (password.length() >= 5) {
            return true;
        }
        return false;
    }

    private static boolean doesPasswordContainDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesPasswordContainSpecialChar(String password) {
        String specialChars = "$%_";
        for (int i = 0; i < password.length(); i++) {
            if (specialChars.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }
}
