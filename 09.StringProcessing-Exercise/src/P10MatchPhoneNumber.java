import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^\\+359( |-)2\\1[\\d]{3}\\1[\\d]{4}$");

        String input;
        while (!"end".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println(input);
            }
        }

        //main ends here
    }
}
