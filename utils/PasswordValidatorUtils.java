package utils;
public class PasswordValidatorUtils {

    public static boolean isPasswordValid(String password) {
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
