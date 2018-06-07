import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^[A-Za-z0-9-_]{3,16}$");
        Matcher matcher;

        List<String> matches = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                matches.add("valid");
            } else {
                matches.add("invalid");
            }
        }

        if (matches.contains("valid")) {
            for (String currentMatch : matches) {
                System.out.println(currentMatch);
            }
        }

        //main ends here
    }
}
