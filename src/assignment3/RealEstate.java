package assignment3;
import java.util.Scanner;

import assignment3.utils.PasswordValidatorUtils;
import assignment3.utils.PhoneNoValidatorUtils;
import assignment3.utils.UsernameAvailabilityValidator;
import assignment3.utils.NewPropertyUtils;

public class RealEstate {
    private Property[] properties;
    private User[] users;
    private City[] cities;

    public RealEstate() {
        this.properties = new Property[0];
        this.users = new User[0];
        this.cities = new City[10];

        setCities();
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

        System.out.println("Would you like to register as a realtor? (true/false)");
        boolean isRealtor = input.nextBoolean();

        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = this.users[i];
        }
        User u = new User(userName, password, phoneNo, isRealtor);
        temp[this.users.length] = u;
        this.users = temp;
        return true;
    }

    public User userLogin(Scanner input) {
        System.out.println("Enter username:");
        String userName = input.next();
        System.out.println("Enter password:");
        String password = input.next();
        for (int i = 0; i < this.users.length; i++) {
            if (users[i].getUserName().equals(userName) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean postNewProperty(User user, Scanner input) {
        return NewPropertyUtils.addNewProperty(user, input, this.cities, this.properties);
    } 
}
