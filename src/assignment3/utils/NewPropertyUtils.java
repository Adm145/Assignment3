package assignment3.utils;
import java.util.Scanner;

import assignment3.City;
import assignment3.User;
import assignment3.Property;

public class NewPropertyUtils {
    
    public static Property createNewProperty(User loggedUser, Scanner input, City[] cities) {
        //checks if user can advertise more properties
        boolean canUserAdvertise = loggedUser.canAdvertiseMore();
        if (!canUserAdvertise) {
            System.out.println("You have reached your advertisement limit and cannot post more properties.");
            return null;
        }
        //property stats
        String cityName = cityHandler(input,cities);
        String streetName = streetsHandler(input, cities, cityName);
        String propertyType = propertyTypeHandler(input);
        int propertyFloor = 0;
        if (propertyType.equals("Apartment") || propertyType.equals("Penthouse")) {
            propertyFloor = numberedValuesHandler(input, "property floor");
        }
        int amountOfRooms = numberedValuesHandler(input, "number of rooms");
        int propertyPrice = numberedValuesHandler(input, "price");
        boolean propertyStatus = propertyStatusHandler(input);
        int propertyNumber = numberedValuesHandler(input, "house number");

        //incrementing user's advertised properties count
        loggedUser.incrementAdvertisedProperties();

        //creating new property
        Property newProperty = new Property(cityName, streetName, amountOfRooms, propertyPrice, propertyType, propertyStatus, propertyNumber, propertyFloor, loggedUser);
        return newProperty;
    }
    //O(n)
    private static String[] getCityStreets(City[] cities, String cityName) {
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                return city.getStreets();
            }
        }
        return null;
    }
    //O(n * k)
    private static String cityHandler(Scanner input, City[] cities) {
        String cityInput = "";
        String[] cityNames = new String[cities.length];
        for (int i = 0; i < cities.length; i++) {
            cityNames[i] = cities[i].getCityName();
        }

        boolean cityFound = false;
        while (!cityFound) {
            System.out.println("Available cities:");
            for (String name : cityNames) {
                System.out.print(name + "\n");
            }
            System.out.println("\n" + "Enter a city from the list above:");
            cityInput = input.next();
            cityInput = cityInput.substring(0, 1).toUpperCase() + cityInput.substring(1);
            
            for (int i = 0; i < cityNames.length; i++) {
                if (cityNames[i].equalsIgnoreCase(cityInput)) { 
                    cityFound = true;
                    break;
                }
            }   
            if (!cityFound) {
                System.out.println("Error: '" + cityInput + "' is not in our system. Please try again.");
            }
        } 
        return cityInput;
    }
    //O(n * k)
    private static String streetsHandler(Scanner input, City[] cities, String cityInput) {
        String streetInput = "";
        String[] streets = getCityStreets(cities, cityInput);
        
        boolean streetFound = false;
        while (!streetFound) {
            streetInput = input.nextLine();
            System.out.println("\nAvailable streets in " + cityInput + ":");
            for (String name : streets) {
                System.out.print(name + "\n");
            }
            System.out.println("\nEnter a street from the list above:");
            streetInput = input.nextLine();
            streetInput = streetInput.substring(0, 1).toUpperCase() + streetInput.substring(1);

            for (int i = 0; i < streets.length; i++) {
                if (streets[i].equalsIgnoreCase(streetInput)) { 
                    streetFound = true;
                    break;
                }
            }   
            if (!streetFound) {
                System.out.println("\nError: '" + streetInput + "' is not in our system. Please try again.");
            }
        }
        return streetInput;
    }
    //O(k)
    private static String propertyTypeHandler(Scanner input) {
        System.out.println("\nPlease choose the property type:");
        System.out.println("1 - for an apartment, 2 - for a penthouse or 3 - for a private house");
        boolean validValue = false;
        while (!validValue) {
            int propertyTypeValue = input.nextInt();
            if (propertyTypeValue == 1) {
                validValue = true;
                return "Apartment";
            } else if (propertyTypeValue == 2) {
                validValue = true;
                return "Penthouse";
            } else if (propertyTypeValue == 3) {
                validValue = true;
                return "Private House";
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        return "";
    }
    //O(k)
    private static int numberedValuesHandler(Scanner input, String parameterName) {
        System.out.println("\nPlease enter the " + parameterName + " of the property:");
        boolean validInput = false;
        while (!validInput) {
            int parameterValue = input.nextInt();
            if (parameterValue > 0) {
                validInput = true;
                return parameterValue;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the " + parameterName + ".");
            }
        }
        return 0;
    }
    //O(k)
    private static boolean propertyStatusHandler(Scanner input) {
        System.out.println("\nIs the property for sale or rent? (s/r)");
        boolean validInput = false;
        while (!validInput) {
            String statusInput = input.next();
            if (statusInput.equalsIgnoreCase("s")) {
                validInput = true;
                return false;
            } else if (statusInput.equalsIgnoreCase("r")) {
                validInput = true;
                continue;
            }
            if (!validInput) {
                System.out.println("Invalid input. Please enter 's' for sell or 'r' for rent.");
            }
        }
        return true;
    }
}
