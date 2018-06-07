import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> orderedChemicals = new TreeSet<>();

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] currentInput = scanner.nextLine().split(" ");

            for (int j = 0; j < currentInput.length; j++) {
                orderedChemicals.add(currentInput[j]);
            }
        }

        for (String chemical : orderedChemicals) {
            System.out.print(chemical + " ");
        }

        //main ends here
    }
}
