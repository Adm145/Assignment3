package assignment3.utils;
import java.util.Scanner;

public class PhoneNoValidatorUtils {

    public static String setPhoneNo(Scanner input) {
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
        return phoneNo;
    }

    public static boolean isPhoneNoValid(String phoneNo) {
        boolean containsOnlyDigits = doesPhoneNoContainOnlyDigits(phoneNo);
        boolean lengthValid = isPhoneNoLengthValid(phoneNo);
        boolean formatValid = isPhoneNoFormatValid(phoneNo);
        if (containsOnlyDigits && lengthValid && formatValid) {
            return true;
        }
        return false;
    }

    private static boolean doesPhoneNoContainOnlyDigits(String phoneNo) {
        for (int i = 0; i < phoneNo.length(); i++) {
            if (!Character.isDigit(phoneNo.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPhoneNoLengthValid(String phoneNo) {
        if (phoneNo.length() == 10) {
            return true;
        }
        return false;
    }

    private static boolean isPhoneNoFormatValid(String phoneNo) {
        if (phoneNo.substring(0, 2).equals("05")) {
            return true;
        }
        return false;
    }
}
