package assignment3.utils;
import java.util.Scanner;

import assignment3.City;
import assignment3.RealEstate;
import assignment3.User;
import assignment3.Property;

public class NewPropertyUtils {
    
    public static boolean addNewProperty(User user, Scanner input, City[] cities , Property[] properties) {
        //checks if user can advertise more properties
        boolean canUserAdvertise = user.canAdvertiseMore();
        if (!canUserAdvertise) {
            System.out.println("You have reached your advertisement limit and cannot post more properties.");
            return false;
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
        //creating new property
        Property newProperty = new Property(cityName, streetName, amountOfRooms, propertyPrice, propertyType, propertyStatus, propertyNumber, propertyFloor, user);
        
        //! ADD NEW PROPERTY TO PROPERTY ARRAY IN REALESTATE
        //adding property to the properties array
        // Property[] temp  = new Property[properties.length + 1];
        // for (int i = 0; i < properties.length; i++) {
        //     temp[i] = properties[i];
        // }
        // temp[properties.length] = newProperty;


        return true;
    }

    private static String[] getCityStreets(City[] cities, String cityName) {
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                return city.getStreets();
            }
        }
        return null;
    }

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
                System.out.print(name + ", ");
            }
            System.out.println("\n" + "Enter a city from the list above:");
            cityInput = input.next();
            
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

    private static String streetsHandler(Scanner input, City[] cities, String cityInput) {
        String streetInput = "";
        String[] streets = getCityStreets(cities, cityInput);

        boolean streetFound = false;
        while (!streetFound) {
            System.out.println("\n" + "Available streets in " + cityInput + ":");
            for (String name : streets) {
                System.out.print(name + ", ");
            }
            System.out.println("\nEnter a street from the list above:");
            streetInput = input.nextLine();

            for (int i = 0; i < streets.length; i++) {
                if (streets[i].equalsIgnoreCase(streetInput)) { 
                    streetFound = true;
                    break;
                }
            }   
            if (!streetFound) {
                System.out.println("Error: '" + streetInput + "' is not in our system. Please try again.");
            }
        }
        return streetInput;
    }

    private static String propertyTypeHandler(Scanner input) {
        System.out.println("Please choose the property type:");
        System.out.println("1 - for an apartment, 2 - for a penthouse or 3 - for a private house");
        int propertyTypeValue = input.nextInt();
        boolean validValue = false;
        while (!validValue) {
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
                propertyTypeValue = input.nextInt();
            }
        }
        return "";
    }

    private static int numberedValuesHandler(Scanner input, String parameterName) {
        System.out.println("Please enter the " + parameterName + " of the property:");
        int parameterValue = input.nextInt();
        while (parameterValue < 0) {
            System.out.println("Invalid " + parameterName + ". Please enter a valid value:");
            parameterValue = input.nextInt();
        }
        return parameterValue;
    }

    private static boolean propertyStatusHandler(Scanner input) {
        System.out.println("Is the property for sale or rent? (s/r)");
        String statusInput = input.next();
        boolean validInput = false;
        while (!validInput) {
            if (statusInput.equalsIgnoreCase("s")) {
                validInput = true;
                return false;
            } else if (statusInput.equalsIgnoreCase("r")) {
                validInput = true;
                return true;
            }
        }
        return false;
    }
}
