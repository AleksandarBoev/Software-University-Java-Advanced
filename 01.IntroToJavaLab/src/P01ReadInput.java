import java.util.Scanner;

public class P01ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word1 = scanner.next("[A-Za-z]+");
        String word2 = scanner.next("\\w+");

        int number1 = Integer.parseInt(scanner.next("[0-9]+"));
        int number2 = Integer.parseInt(scanner.next("[0-9]+"));
        int number3 = Integer.parseInt(scanner.next("[0-9]+"));


        String word3 = scanner.next("[A-Za-z]+");

        System.out.printf("%s %s %s %d", word1, word2, word3, (number1 + number2 + number3));
        //main ends here
    }
}
