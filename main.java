import java.util.Scanner;
import utils.MenuUtils;

public class main {
    public static void main(String[] args) {
        RealEstate app = new RealEstate();
        Scanner input = new Scanner(System.in);
        launchApp(app, input);
    }

    public static void launchApp(RealEstate app, Scanner input) {
        int mainMenuChoice = MenuUtils.getMainMenuChoice(input, app);
        if (mainMenuChoice == 1) {
            app.createUser(input);
        } else if (mainMenuChoice == 2) {
            User u = app.userLogin(input);
            if (u == null) {
                System.out.println("Invalid username or password, please try again.");
            } else {
                System.out.println("Login successful! Welcome, " + u.getUserName() + "!");
            }
        } else if (mainMenuChoice == 3) {
            System.out.println("Thank you for using the Real Estate Application. Goodbye!");
        }
    }
}
