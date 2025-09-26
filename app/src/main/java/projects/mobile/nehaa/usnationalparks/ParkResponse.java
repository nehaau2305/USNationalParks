package projects.mobile.nehaa.usnationalparks;

import java.util.List;

/**
 * ParkResponse is an API response wrapper class to handle top-level
 * fields like the things outside the data field and the data field itself
 */
public class ParkResponse {
    private String total;
    private List<Park> data;

    public String getTotal() { return total;}
    public List<Park> getData() { return data; }
}
