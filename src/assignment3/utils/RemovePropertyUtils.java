package assignment3.utils;
import java.util.Scanner;

import assignment3.Property;

public class RemovePropertyUtils {
    public static int removeProperty(Property[] propertiesByUser, Scanner input, Property[] properties) {
        printPropertiesArray(propertiesByUser);

        int propertyNumberToRemove = 0;
        boolean validPropertyNumberInput = false;
        //loop checks for a valid property number by id
        while (!validPropertyNumberInput) {
            System.out.println("\nPlease enter the number of the property you would like to remove:");
            propertyNumberToRemove = input.nextInt();
            validPropertyNumberInput = isValidPropertyNumber(propertyNumberToRemove, propertiesByUser);
            if (!validPropertyNumberInput) {
                System.out.println("Please try again and choose a valid property number:");
                System.out.println("(the property number is listed above each property)");
                printPropertiesArray(propertiesByUser);
            }
        }
        return propertyNumberToRemove;
    }

    public static void printPropertiesArray(Property[] propertiesList) {
        for (int i = 0; i < propertiesList.length; i++) {
            System.out.println(propertiesList[i].getPropertyId() + ").\n" + propertiesList[i].toString() + "\n");
        }
    } 

    private static boolean isValidPropertyNumber(int propertyNumber, Property[] propertiesByUser) {
        for (int i = 0; i < propertiesByUser.length; i++) {
            if (propertiesByUser[i].getPropertyId() == propertyNumber) {
                return true;
            }
        }
        return false;
    }
}
