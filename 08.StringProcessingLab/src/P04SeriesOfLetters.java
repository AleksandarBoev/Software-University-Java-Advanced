import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04SeriesOfLetters { // TODO do it with FSM
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder().append(reader.readLine());

        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i + 1);
            } else {
                i++;
            }
        }

        System.out.println(sb.toString());
        //main ends here
    }
}
