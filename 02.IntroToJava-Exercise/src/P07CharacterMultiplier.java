import java.util.Scanner;

public class P07CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String longerWord;
        String shorterWord;
        String[] input = scanner.nextLine().split(" ");
        if (input[0].length() < input[1].length()) {
            shorterWord = input[0];
            longerWord = input[1];
        } else {
            longerWord = input[0];
            shorterWord = input[1];
        }

        int sum = 0;
        for (int currentChar = 0; currentChar < shorterWord.length(); currentChar++) {
            sum += shorterWord.charAt(currentChar) * longerWord.charAt(currentChar);
        }

        if (shorterWord.length() != longerWord.length()) {
            for (int currentChar = shorterWord.length(); currentChar < longerWord.length(); currentChar++) {
                sum += longerWord.charAt(currentChar);
            }
        }

        System.out.println(sum);

        //main ends here
    }
}
