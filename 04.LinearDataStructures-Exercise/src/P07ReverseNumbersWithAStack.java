import java.util.ArrayDeque;
import java.util.Scanner;

public class P07ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            stack.push(tokens[i]);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        //main ends here
    }
}
