import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputText = reader.readLine();
        String substringToCheck = reader.readLine();

        int count = 0;
        int progressIndex = 0;
        while (true) {
            progressIndex = inputText.toLowerCase().indexOf(substringToCheck.toLowerCase(), progressIndex); // case insensitive

            if (progressIndex == -1) {
                break;
            } else {
                progressIndex++;
                count++;
            }
        }

        System.out.println(count);

        //main ends here
    }
}
