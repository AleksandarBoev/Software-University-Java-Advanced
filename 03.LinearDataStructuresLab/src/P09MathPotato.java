import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P09MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int hotPotatoPasses = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, names);

        int counter = 1;
        int peopleRemoved = 1;
        while (queue.size() > 1) {
            if (counter == hotPotatoPasses && !isPrime(peopleRemoved)) {
                System.out.printf("Removed %s%n", queue.remove()); // person is out of the game for good
                counter = 1;
                peopleRemoved++;
            } else if (counter == hotPotatoPasses && isPrime(peopleRemoved)){
                System.out.printf("Prime %s%n", queue.peek());
                counter = 1;
                peopleRemoved++;
            } else {
                queue.add(queue.remove()); // from first, the person becomes last
                counter++;
            }
        }

        System.out.printf("Last is %s", queue.remove());
        //main ends here
    }

    static boolean isPrime(int number) {
        if (number == 1 || number == 0)
            return false;

        if (number == 2)
            return true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (1.0 * number / i == number / i) {
                return false;
            }
        }

        return true;
    }

}
