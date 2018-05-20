import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P08HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int hotPotatoPasses = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, names);

        int counter = 1;
        while (queue.size() > 1) {
            if (counter == hotPotatoPasses) {
                System.out.printf("Removed %s%n", queue.remove()); // person is out of the game for good
                counter = 1;
            } else {
                queue.add(queue.remove()); // from first, the person becomes last
                counter++;
            }
        }

        System.out.printf("Last is %s", queue.remove());
        //main ends here
    }
}
