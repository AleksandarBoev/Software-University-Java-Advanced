import java.util.ArrayDeque;
import java.util.Scanner;

public class P12BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.length() % 2 != 0) {
            System.out.println("NO");
            return;
        }

        ArrayDeque<Character> parenthesisStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                parenthesisStack.push(input.charAt(i));
            } else { // ')' || ']' || '}'
                char closingParenthesis = input.charAt(i);
                boolean notSymmetrical = false;
                switch (closingParenthesis) {
                    case ')':
                        if (parenthesisStack.pop() != '(') {
                            notSymmetrical = true;
                        }
                        break;
                    case ']':
                        if (parenthesisStack.pop() != '[') {
                            notSymmetrical = true;
                        }
                        break;
                    case '}':
                        if (parenthesisStack.pop() != '{') {
                            notSymmetrical = true;
                        }
                        break;
                }
                if (notSymmetrical) {
                    System.out.println("NO");
                    return;
                }

            }
        }

        System.out.println("YES");

        //main ends here
    }
}
