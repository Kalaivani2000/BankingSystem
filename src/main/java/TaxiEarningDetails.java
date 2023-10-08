public class TaxiEarningDetails {
    private int bookingId;
    private int customerId;
    private String from;
    private String to;
    private int pickUpTime;
    private int dropTime;
    private double totalAmount;

    public TaxiEarningDetails(int bookingId,int customerId,String from,String to,int pickUpTime,int dropTime,double totalAmount) {
        this.bookingId = bookingId;
        this.customerId=customerId;
        this.from=from;
        this.to=to;
        this.pickUpTime=pickUpTime;
        this.dropTime=dropTime;
        this.totalAmount=totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
