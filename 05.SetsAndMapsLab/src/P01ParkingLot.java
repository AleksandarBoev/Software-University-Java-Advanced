import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new HashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(", ");

            if ("IN".equals(tokens[0])) {
                cars.add(tokens[1]);
            } else {
                cars.remove(tokens[1]);
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
        //main ends here
    }
}
