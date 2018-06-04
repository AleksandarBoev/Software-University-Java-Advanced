import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder().append(reader.readLine());
        StringBuilder shake = new StringBuilder().append(reader.readLine());

        if (shake.length() == 0 || input.length() < shake.length()) {
            System.out.println("No shake.");
            return;
        }

        while (true) {

            int match1 = input.indexOf(shake.toString(), 0);
            int match2 = input.lastIndexOf(shake.toString(), input.length() - 1);

            if (match1 != match2 && match1 != -1) { // if there are at least 2 different matches
                input.delete(match2, match2 + shake.length());
                input.delete(match1, match1 + shake.length());

                System.out.println("Shaked it.");

                shake.delete(shake.length() / 2, shake.length() / 2 + 1);
                if (shake.length() == 0 || input.length() < shake.length()) {
                    System.out.println("No shake.");
                    break;
                }
            } else {
                System.out.println("No shake.");
                break;
            }
        }

        System.out.println(input);
        //main ends here
    }
}
