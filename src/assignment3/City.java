package assignment3;
public class City {
    private String cityName;
    private String county;
    private String[] streetList;

    public City(String cityName, String county, String[] streetList) {
        this.cityName = cityName;
        this.county = county;
        this.streetList = streetList;
    }

    public String[] getStreets() {
        return this.streetList;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String[] getStreetList() {
        return this.streetList;
    }
}
