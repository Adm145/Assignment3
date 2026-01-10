package utils;
public class PhoneNoValidatorUtils {
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
