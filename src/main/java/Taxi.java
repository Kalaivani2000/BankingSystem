import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiNumber;
    private double totalEarnings;
    private String currentLocation;
    private int nextAvailableTime;

    public List<TaxiEarningDetails> getTaxiEarningDetailsList() {
        return taxiEarningDetailsList;
    }

    public void setTaxiEarningDetailsList(List<TaxiEarningDetails> taxiEarningDetailsList) {
        this.taxiEarningDetailsList = taxiEarningDetailsList;
    }

    private List<TaxiEarningDetails>taxiEarningDetailsList=new ArrayList<TaxiEarningDetails>();

    public Taxi(int taxiNumber, double totalEarnings, String currentLocation, int nextAvailableTime){
        this.taxiNumber=taxiNumber;
        this.totalEarnings=totalEarnings;
        this.currentLocation=currentLocation;
        this.nextAvailableTime=nextAvailableTime;
    }
    public int getTaxiNumber() {
        return taxiNumber;
    }

    public void setTaxiNumber(int taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public int getNextAvailableTime() {
        return nextAvailableTime;
    }

    public void setNextAvailableTime(int nextAvailableTime) {
        this.nextAvailableTime = nextAvailableTime;
    }
}
