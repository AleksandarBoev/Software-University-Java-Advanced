import java.util.ArrayDeque;
import java.util.Scanner;

public class P15InfixToPostfix {
    public static void main(String[] args) { // TODO finish this
        //from wikipedia: Like the evaluation of RPN, the shunting yard algorithm is stack-based.
        Scanner scanner = new Scanner(System.in);

        //the algorithm on this page https://upload.wikimedia.org/wikipedia/commons/2/24/Shunting_yard.svg :
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operationsStack = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            try {
                int number = Integer.parseInt(tokens[i]);
                outputQueue.add(String.valueOf(number));
            } catch (NumberFormatException nfe) { //how to check which exception to use: break program and copy paste from the error report
                char operator = tokens[i].charAt(0);
                switch (operator) {
                    case '+': case '-':

                        break;

                }
            }
        }
        //main ends here
    }
}
