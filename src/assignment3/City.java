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
    //O(1)
    public String[] getStreets() {
        return this.streetList;
    }
    //O(1)
    public String getCityName() {
        return this.cityName;
    }
    //O(1)
    public String[] getStreetList() {
        return this.streetList;
    }
}
