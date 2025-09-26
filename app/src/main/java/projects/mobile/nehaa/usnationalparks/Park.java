package projects.mobile.nehaa.usnationalparks;

import java.util.List;

/**
 * The Park class initializes all the desired variables within the data variable
 * from ParkResponse
 */
public class Park {
    private List<Address> addresses;
    private List<Contact> contacts;
    private String description;
    private List<EntranceFee> entranceFees;
    private List<EntrancePass> entrancePasses;
    private String fullName;
    private String states;
    private String url;
    private String weatherInfo;


    public List<Address> getAddresses() { return addresses; }
    public List<Contact> getContacts() { return contacts; }
    public String getDescription() { return description; }
    public List<EntranceFee> getEntranceFees() { return entranceFees; }
    public List<EntrancePass> getEntrancePasses() { return entrancePasses; }
    public String getFullName() { return fullName; }
    public String getStates() { return states; }
    public String getUrl() { return url; }
    public String getWeatherInfo() { return weatherInfo; }
}
