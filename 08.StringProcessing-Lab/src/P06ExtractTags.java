import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<.+?>"); // TODO research more the "lazy" search
        Matcher matcher;

        String input;
        while (!"END".equals(input = reader.readLine())) {
            matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
        //main ends here
    }
}
