package assignment3.utils;
import java.util.Scanner;

import assignment3.Property;

public class SearchPropertyUtil {
    //O(n^3)
    public static void searchHandler(Scanner Input, Property[] properties) {
        String propertyStatusQuery = getPropertyStatusQuery(Input);
        String propertyTypeQuery = getPropertyTypeQuery(Input);
        int roomAmountQuery = getRoomAmountQuery(Input);

        System.out.println("Please enter your maximum price?");
        int maxPriceQuery = getPriceQuery(Input);
        System.out.println("Please enter your minimum price?");
        int minPriceQuery = getPriceQuery(Input);
        Property[] filteredPropertyList =  filteredList(properties, propertyStatusQuery, propertyTypeQuery, roomAmountQuery, maxPriceQuery, minPriceQuery);
        
        RemovePropertyUtils.printPropertiesArray(filteredPropertyList); //O(n)
    }
    //O(k)
    private static String getPropertyStatusQuery(Scanner input) {
        System.out.println("\nAre you looking for a properties for sale or rent?");
        System.out.println("(r - for rent / s - for sale / -999 to not include parameter)");
        boolean validInput = false;
        while(!validInput) {
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("s")) {
                validInput = true;
                return "Sale";
            } else if (userInput.equalsIgnoreCase("r")) {
                validInput = true;
                return "Rent";
            } else if (userInput.equalsIgnoreCase("-999")) {
                return "-999";
            }
            if (!validInput) {
                System.out.println("Invalid input, Please enter a valid input");
                System.out.println("(r - for rent / s - for sale)");
            }
        }
        return "";
    }
    //O(k)
    private static String getPropertyTypeQuery(Scanner input) {
        System.out.println("\nWhat type of property are you looking for?");
        System.out.println("(1 - for an apartment / 2 - for a penhouse / 3 - for a private home / -999 to not include parameter");
        boolean validInput = false;
        while(!validInput) {
            String userInput = input.next();
            if (userInput.equals("1")) {
                validInput = true;
                return "Apartment";
            } else if(userInput.equals("2")) {
                validInput = true;
                return "Penthouse";
            } else if(userInput.equals("3")) {
                validInput = true;
                return "Private House";
            } else if (userInput.equals("-999")) {
                return "-999";
            }
            if (!validInput) {
                System.out.println("Invalid input, Please enter a valid input");
                System.out.println("(1 - for an apartment / 2 - for a penhouse / 3 - for a private home / -999 to not include parameter in search");
            }
        }
        return "";
    }
    //O(k)
    private static int getRoomAmountQuery(Scanner input) {
        System.out.println("\nHow many rooms would you like the property to have?");
        System.out.println("or enter '-999' to not include parameter in the search");
        boolean validInput = false;
        while (!validInput) {
            int rommAmountValue = input.nextInt();
            if (rommAmountValue > 0) {
                validInput = true;
                return rommAmountValue;
            } else if (rommAmountValue == -999) {
                return -999; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return 0;
    }
    //O(k)
    private static int getPriceQuery(Scanner input) {
        System.out.println("or enter '-999' to not include parameter in the search");
        boolean validInput = false;
        while (!validInput) {
            int priceQuery = input.nextInt();
            if (priceQuery > 0) {
                validInput = true;
                return priceQuery;
            } else if (priceQuery == -999) {
                return -999; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return 0;
    }
    //O(n^3)
    private static Property[] filteredList(Property[] properties,String statusQuery, String typeQuery, int roomAmount, int maxPrice, int minPrice) {
        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            boolean isMatch = matchFinder(properties, statusQuery, typeQuery, roomAmount, maxPrice, minPrice);
            if (isMatch) {
                count++;
            }
        }   
        Property[] filteredPropertyList = new Property[count];
        int index = 0;
        for (int i = 0; i < properties.length; i++) {
            boolean isMatch = matchFinder(properties, statusQuery, typeQuery, roomAmount, maxPrice, minPrice);
            if (isMatch) {
                filteredPropertyList[index] = properties[i];
                index++;
            }
        }
        return filteredPropertyList;
    }
    //O(n)
    private static boolean matchFinder(Property[] properties,String statusQuery, String typeQuery, int roomAmount, int maxPrice, int minPrice) {
        for (int i = 0; i < properties.length; i++) {
            if (!statusQuery.equals("-999")) {
                if (!statusQuery.equalsIgnoreCase(properties[i].getPropertyStatus())) {
                    return false;
                }
            }
            if (!typeQuery.equals("-999")) {
                if (!typeQuery.equalsIgnoreCase(properties[i].getPropertyType())) {
                    return false;
                }
            }
            if (roomAmount != -999) {
                if (roomAmount != properties[i].getAmountOfRooms()) {
                    return false;
                }
            }
            if (minPrice != -999) {
                if (properties[i].getPrice() < minPrice) {
                    return false;
                }
            }
            if (maxPrice != -999) {
                if (properties[i].getPrice() > maxPrice) {
                    return false;
                }
            }
        }
        return true;
    }

}
