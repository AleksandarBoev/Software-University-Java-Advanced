import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P12VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cars = new ArrayList<>(); // using a list and not a hashset, because the can be multiple cars with the same name
        cars = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int vehiclesAtStart = cars.size();

        while(true) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }
            String currentCar = ("" + input[0].charAt(0)).toLowerCase() + input[2];
            if (cars.contains(currentCar)) {
                int price = input[0].toLowerCase().charAt(0) * Integer.parseInt(input[2]);
                System.out.printf("Yes, sold for %d$%n", price);
                cars.remove(currentCar);
            } else {
                System.out.println("No");
            }
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", cars));
        System.out.printf("Vehicles sold: %d", vehiclesAtStart - cars.size());
        //main ends here
    }
}
