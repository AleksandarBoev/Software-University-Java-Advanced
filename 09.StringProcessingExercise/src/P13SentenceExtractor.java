import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SentenceExtractor { //TODO 60/100
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String part1Regex = "\\b.*? ";
        String part2Regex = reader.readLine();
        String part3Regex = " .*?[\\.!\\?]";

        Pattern pattern = Pattern.compile(part1Regex + Pattern.quote(part2Regex) + part3Regex);

        String input = reader.readLine();

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        //main ends here
    }
}
