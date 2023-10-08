import java.util.List;

public class Main2 {
    public static void main(String[]args){
        TaxiBooking taxiBooking=new TaxiBooking(5);
        List<Taxi> taxis=taxiBooking.createTaxis();
        int choice=taxiBooking.selectOption();
        while (choice!=3){
            switch (choice){
                case 1:
                    taxiBooking.bookTaxi(taxis);
                    break;
                case 2:
                    taxiBooking.printDetails(taxis);
                    break;
                default:
                    System.out.println("The option is invalid");
            }
            choice=taxiBooking.selectOption();
        }
        System.out.println("Exit the program");
    }
}
