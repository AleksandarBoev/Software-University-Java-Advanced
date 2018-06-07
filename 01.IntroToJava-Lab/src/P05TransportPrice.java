import java.math.BigDecimal;
import java.util.Scanner;

public class P05TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distanceToTravel = Double.parseDouble(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double totalPrice = 0.0;

        if (distanceToTravel < 20) {
            totalPrice = 0.70;
            if (timeOfDay.equals("day")) {
                totalPrice += 0.79 * distanceToTravel;
            } else {
                totalPrice += 0.90 * distanceToTravel;
            }
        } else if (distanceToTravel < 100) {
            totalPrice = 0.09 * distanceToTravel;

        } else {
            totalPrice = 0.06 * distanceToTravel;
        }

        System.out.printf("%.2f", totalPrice);

        //main ends here
    }
}
