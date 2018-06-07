import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSetLength = scanner.nextInt();
        int secondSetLength = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (Integer number : firstSet) { // doesn't matter which set will be iterated
            if (secondSet.contains(number)) {
                System.out.print(number + " ");
            }
        }
        //main ends here
    }
}
