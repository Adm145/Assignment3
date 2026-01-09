import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        launchApp();
    }

    public static void launchApp() {
        System.out.println("Welcome to the Real Estate Application!");
        System.out.println("Would you like to log in or sign up?");
        System.out.println("(1 - Create an account, 2 - Log in, 3 - end program)");
        Scanner input = new Scanner(System.in);
        boolean validChoice = false;
        for (;!validChoice;) {
            int choice = input.nextInt();
            if (choice == 1) {
                createUser();
                validChoice = true;
            } else if (choice == 2) {
                loginUser();
                validChoice = true;
            } else if (choice == 3) {
                System.out.println("Thank you for using the Real Estate Application. Goodbye!");
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        input.close();
    }

    public static void createUser() {}

    public static void loginUser() {}
}
