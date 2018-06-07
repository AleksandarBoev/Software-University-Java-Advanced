import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P05SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String tokens[] = scanner.nextLine().split("\\s+");

        Collections.addAll(stack, tokens); // puts everything in the order of the second parameter

        while (stack.size() != 1) {
            int operand1 = Integer.parseInt(stack.pop());
            char operator = stack.poll().charAt(0);
            int operand2 = Integer.parseInt(stack.pop());

            int result = 0;
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
            }

            stack.push("" + result);
        }

        System.out.println(stack.pop());
        //main ends here
    }
}
