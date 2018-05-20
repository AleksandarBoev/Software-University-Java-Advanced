import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> stackBracketBeginPosition = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            if ('(' == expression.charAt(index)) {
                stackBracketBeginPosition.push(index);
            } else if (')' == expression.charAt(index)) {
                System.out.println(expression.substring(stackBracketBeginPosition.pop(), index + 1));
            }
        }

        //main ends here
    }
}
