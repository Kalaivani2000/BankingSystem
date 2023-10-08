import java.util.*;

public class TaxiBooking {
    private final int numberOFTaxis;
    Map<String, Integer> locationMap = Map.of("A", 1, "B", 2, "C", 3, "D", 4, "E", 5);
    private int customerId = 0;
    private int bookingId = 0;

    public TaxiBooking(int numberOFTaxis) {
        this.numberOFTaxis = numberOFTaxis;
    }

    public List<Taxi> createTaxis() {
        List<Taxi> taxis = new ArrayList<>();
        for (int i = 1; i <= numberOFTaxis; i++) {
            taxis.add(new Taxi(i, 0, "A", 5));
        }
        return taxis;
    }

    public int selectOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n...................Taxi_Booking..............................................");
        System.out.println("1.Booking");
        System.out.println("2.Details");
        System.out.println("3.exit");
        System.out.print("Enter Choice:");
        return scanner.nextInt();
    }

    public void bookTaxi(List<Taxi> taxis) {
        Map<String, Object> bookingDetails = getDetailsBooking();
        String pickUpPoint = (String) bookingDetails.get("PickUpPoint");
        String dropPoint = (String) bookingDetails.get("DropPoint");
        int pickUpTime = (int) bookingDetails.get("PickUpTime");
        List<Taxi> availableTaxis = getAvailableTaxis(pickUpTime, pickUpPoint, dropPoint, taxis);
        if (availableTaxis.isEmpty()) {
            System.out.println("All Taxis Are Busy. Please Try After Some Time");
            return;
        }
        Taxi taxi = getTaxi(availableTaxis);
        System.out.println("Taxi " + taxi.getTaxiNumber() + " is allotted");
        int taxiFare = calculateTaxiFare(pickUpPoint, dropPoint);
        taxi.setTotalEarnings(taxi.getTotalEarnings() + taxiFare);
    }


    private List<Taxi> getAvailableTaxis(int pickUpTime, String pickUpPoint, String dropPoint, List<Taxi> taxis) {
        List<Taxi> availableTaxis = new ArrayList<>();
        int requiredTimeToPickUp = Math.abs(locationMap.get(dropPoint) - locationMap.get(pickUpPoint));
        for (Taxi taxi : taxis) {
            if (taxi.getNextAvailableTime() + requiredTimeToPickUp <= pickUpTime) {
                availableTaxis.add(taxi);
            }
        }
        return availableTaxis;
    }

    private Taxi getTaxi(List<Taxi> availableTaxis) {
        Taxi taxi = availableTaxis.get(0);
        for (Taxi availableTaxi : availableTaxis) {
            if (availableTaxi.getTotalEarnings() < taxi.getTotalEarnings()) {
                taxi = availableTaxi;
            }
        }
        return taxi;
    }

    private int calculateTaxiFare(String pickUpPoint, String dropPoint) {
        int distanceToTravel = Math.abs(locationMap.get(dropPoint) - locationMap.get(pickUpPoint));
        int distance = distanceToTravel * 15;
        return 100 + (distance - 5) * 10;
    }

   private TaxiEarningDetails getTaxiEarningDetails(String pickUpPoint,String dropPoint,int pickUpTime,int taxiFare){
       int distanceToTravel=Math.abs(locationMap.get(dropPoint)-locationMap.get(pickUpPoint));
       int nextAvailableTime=pickUpTime+distanceToTravel;
       return new TaxiEarningDetails(++bookingId,++customerId,pickUpPoint,dropPoint,
               pickUpTime,nextAvailableTime,taxiFare);
   }

    private Map<String, Object> getDetailsBooking() {
        Map<String, Object> bookingDetails = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pickUp point:");
        bookingDetails.put("pickUpPoint", scanner.nextLine());
        System.out.println("Enter the drop point:");
        bookingDetails.put("dropPoint", scanner.nextLine());
        System.out.println("Enter the pickUp time:");
        bookingDetails.put("pickUpTime", scanner.nextLine());
        return bookingDetails;
    }

    public void printDetails(List<Taxi> taxis) {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi Number:" + taxi.getTaxiNumber());
            System.out.println("Total Earning:" + taxi.getTotalEarnings());
            for (TaxiEarningDetails taxiEarningDetails : taxi.getTaxiEarningDetailsList()) {
                System.out.println("Booking Id: " + taxiEarningDetails.getBookingId());
                System.out.println("Customer Id: " + taxiEarningDetails.getCustomerId());
                System.out.println("From: " + taxiEarningDetails.getFrom());
                System.out.println("To: " + taxiEarningDetails.getTo());
                System.out.println("PickUp Time: " + taxiEarningDetails.getPickUpTime());
                System.out.println("Drop time: " + taxiEarningDetails.getDropTime());
                System.out.println("Total Amount: " + taxiEarningDetails.getTotalAmount());
                System.out.println("--------------------------------------------------------------");
            }
//            System.out.println("//////////////////////////////////////////////////////////////////");
        }

    }
}
