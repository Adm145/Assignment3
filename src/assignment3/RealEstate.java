package assignment3;
import java.util.Scanner;

import assignment3.utils.PasswordValidatorUtils;
import assignment3.utils.PhoneNoValidatorUtils;
import assignment3.utils.UsernameAvailabilityValidator;
import assignment3.utils.UserTypeChoiceUtils;
import assignment3.utils.NewPropertyUtils;
import assignment3.utils.RemovePropertyUtils;
import assignment3.utils.SearchPropertyUtil;

public class RealEstate {
    private Property[] properties;
    private User[] users;
    private City[] cities;

    public RealEstate() {
        this.properties = new Property[0];
        this.users = new User[0];
        this.cities = new City[10];

        setCities();
        setInitialUser();
    }

    private void setCities() {
        this.cities[0] = new City("Ashdod", "Southern", new String[]{"Kohav HaTsafon St", "Tamuz St", "Adar St"});
        this.cities[1] = new City("Ashkelon", "Southern", new String[]{"Ha-Histadrut St", "Gyora Yoseftal St", "Ephraim Tsur St"});
        this.cities[2] = new City("Sderot", "Southern", new String[]{"Horad St", "Nizsan St", "Keren Hayedos St"});
        this.cities[3] = new City("Beer-Sheva", "Negev", new String[]{"Shapira St", "Balfur St", "Sokolov St"});
        this.cities[4] = new City("Tel-Aviv", "Center", new String[]{"HaKongres St", "Bar Yokhai St", "Elyakum St"});
        this.cities[5] = new City("Rishon Lezion", "Center", new String[]{"Nordau St", "Lubman St", "Bilu St"});
        this.cities[6] = new City("Kfar Sava", "Sharon", new String[]{"Nakhshon St", "HaCarmel St", "Weizmann St"});
        this.cities[7] = new City("Netanya", "Sharon", new String[]{"Ha-Negev St", "Lavontin St", "Dizengoff St"});
        this.cities[8] = new City("Haifa", "North", new String[]{"Masada St", "Bar Giyora St", "Ramban St"});
        this.cities[9] = new City("Acre", "North", new String[]{"David Noy St", "HaAtsmaut St", "Ben Ami St"});
    }

    private void setInitialUser() {
        User newUser = new User("adm145", "123456!", "0536205634", true);
        setUserToUsersArray(newUser);
    }

    //! private void setInitialProperties() {}

    public String[] getCitiesNames() {
        String[] cityNames = new String[this.cities.length];
        for (int i = 0; i < this.cities.length; i++) {
            cityNames[i] = this.cities[i].getCityName();
        }
        return cityNames;
    }

    public boolean createUser(Scanner input) {
        String userName = UsernameAvailabilityValidator.setUserName(input, this.users);
        String password = PasswordValidatorUtils.setPassword(input);
        String phoneNo = PhoneNoValidatorUtils.setPhoneNo(input);
        boolean isRealtor = UserTypeChoiceUtils.setIsRealtor(input);
        //new user creation
        User newUser = new User(userName, password, phoneNo, isRealtor);
        setUserToUsersArray(newUser);
        return true;
    }
    
    private void setUserToUsersArray(User newUser) {
        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = this.users[i];
        }
        temp[this.users.length] = newUser;
        this.users = temp;
    }

    public User userLogin(Scanner input) {
        System.out.println("Enter username:");
        String userName = input.next();
        System.out.println("Enter password:");
        String password = input.next();
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUserName().equals(userName) && this.users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean postNewProperty(User loggedUser, Scanner input) {
        Property newProperty = NewPropertyUtils.createNewProperty(loggedUser, input, this.cities);
        if (newProperty == null) {
            return false;
        }
        setPropertyToPropertiesArray(newProperty);
        return true;
    }

    private void setPropertyToPropertiesArray(Property newProperty) {
        Property[] temp  = new Property[this.properties.length + 1];
        for (int i = 0; i < this.properties.length; i++) {
            temp[i] = this.properties[i];
        }
        temp[this.properties.length] = newProperty;
        this.properties = temp;
    }

    public void removeProperty(User loggedUser, Scanner input) {
        if (loggedUser.getAdvertisedProperties() == 0) {
            System.out.println("\nYou have no advertised properties to remove.");
            return;
        }
        Property[] propertiesByUser = getPropertiesPostedByUser(loggedUser);
        int propertyToRemove = RemovePropertyUtils.removeProperty(propertiesByUser, input, this.properties);
        removePropertyFromPropertiesArray(propertyToRemove);
    }

    private Property[] getPropertiesPostedByUser(User loggedUser) {
        int count = 0;
        for (int i = 0; i < this.properties.length; i++) {
            if (this.properties[i].getPropertyPoster().equals(loggedUser.getUserName())) {
                count++;
            }
        }
        int internalCount = 0;
        Property[] propertiesByUser = new Property[count];
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getPropertyPoster().equals(loggedUser.getUserName())) {
                propertiesByUser[internalCount] = properties[i];
                internalCount++;
            }
        }
        return propertiesByUser;
    }

    private void removePropertyFromPropertiesArray(int propertyToRemove) {
        Property[] temp = new Property[this.properties.length - 1];
        int index = 0;
        for (int i = 0; i < this.properties.length; i++) {
            int currentPropertyId = this.properties[i].getPropertyId();
            if (currentPropertyId != propertyToRemove) {
                temp[index] = this.properties[i];
                index++;
            }
        }
        this.properties = temp;
    }

    public void printAllProperties() {
        for (int i = 0; i < this.properties.length; i++) {
            System.out.println(this.properties[i].toString() + "\n");
        }
    }

    public void printPropertiesByUser(User loggedUser) {
        Property[] propertiesByUser = getPropertiesPostedByUser(loggedUser);
        RemovePropertyUtils.printPropertiesArray(propertiesByUser);
    }

    public void search(Scanner Input) {
        System.out.println("Please fill out the following search queries to find the best fit for you:");
        SearchPropertyUtil.searchHandler(Input, properties);
    }
}