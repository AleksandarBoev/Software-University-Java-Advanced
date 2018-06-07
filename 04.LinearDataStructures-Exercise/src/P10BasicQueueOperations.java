import java.util.ArrayDeque;
import java.util.Scanner;

public class P10BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElementsToBeAdded = scanner.nextInt();
        int numberOfElementsToBeRemoved = scanner.nextInt();
        int elementToBeChecked = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        for (int i = 0; i < numberOfElementsToBeAdded; i++) {
            int currentElement = Integer.parseInt(tokens[i]);
            queue.add(currentElement);
        }

        for (int i = 0; i < numberOfElementsToBeRemoved; i++) {
            queue.remove();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (queue.contains(elementToBeChecked)) {
            System.out.println(true);
        } else {
            System.out.println(getMin(queue));
        }

        //main ends here
    }

    static int getMin(ArrayDeque<Integer> queue) {
        int smallestElement = Integer.MAX_VALUE;

        for (int i = 0; i < queue.size(); i++) {
            if (smallestElement > queue.peek()) {
                smallestElement = queue.peek();
            }
            queue.add(queue.remove());
        }

        return smallestElement;
    }

}
