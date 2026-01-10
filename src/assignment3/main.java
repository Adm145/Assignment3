package assignment3;
import java.util.Scanner;
import assignment3.utils.MenuUtils;

public class main {
    public static void main(String[] args) {
        RealEstate app = new RealEstate();
        Scanner input = new Scanner(System.in);
        launchApp(app, input);
    }

    public static void launchApp(RealEstate app, Scanner input) {
        MenuUtils.mainMenu(input, app);
    }
}
