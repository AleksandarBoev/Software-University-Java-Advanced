import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElementsToPush = scanner.nextInt();
        int numberOfElementsToPop = scanner.nextInt();
        int numberToBeChecked = scanner.nextInt();
        scanner.nextLine();

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(Integer.parseInt(tokens[i]));
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (stack.contains(numberToBeChecked)) {
            System.out.println(true);
        } else {
            int smallestElement = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int currentElement = stack.pop();
                if (currentElement < smallestElement) {
                    smallestElement = currentElement;
                }
            }

            System.out.println(smallestElement);
        }

        //main ends here
    }
}
