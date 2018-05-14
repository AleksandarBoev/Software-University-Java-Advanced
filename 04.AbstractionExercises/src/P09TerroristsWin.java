import java.util.Scanner;

public class P09TerroristsWin {
    public static void main(String[] args) {
        //Unresolved problem: input "123456|a|123456", which has length 15 is changed to "......"
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        while (input.indexOf("|") != -1) {
            int substringStart = input.indexOf("|");
            int substringEnd = input.indexOf("|", substringStart + 1);
            String bomb = input.substring(substringStart + 1, substringEnd); // bomb letters, without '|'
            int blastRadius = calculateCharsSum(bomb) % 10;

            int startReplacing = substringStart - blastRadius;
            int stopReplacing = substringEnd + blastRadius;

            for (int i = startReplacing; i <= stopReplacing; i++) { //there has to be a smarter way of doing this
                try {
                    input.replace(i, i+1, ".");
                } catch (Exception e) {
                    continue;
                }
            }

        }

        System.out.println(input);
        //main ends here
    }

    static int calculateCharsSum(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
        }
        return sum;
    }

    static String buildString(char character, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

}
