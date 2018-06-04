import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14SumOfAllValues { // TODO skarai im se che vhodut v word fail-a e sburkan
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern startKeyEndKeyRegex = Pattern.compile("(?<startKey>[A-z_]+)[0-9].*[0-9](?<endKey>[A-z_]+)");
        Matcher matcher = startKeyEndKeyRegex.matcher(reader.readLine());

        if (!matcher.matches()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String startKey = matcher.group("startKey");
        String endKey = matcher.group("endKey");

        String textString = reader.readLine();

        Pattern pattern = Pattern.compile(Pattern.quote(startKey) + "(.+?)" + Pattern.quote(endKey));
        matcher = pattern.matcher(textString);

        double sum = 0.0;
        while (matcher.find()) {
            try {
                sum += Double.parseDouble(matcher.group(1));
            } catch (Exception e) {

            }
        }

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
            return;
        }

        if ((long)sum == sum) {
            System.out.printf("<p>The total value is: <em>%d</em></p>", (long)sum);
        } else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }

        //main ends here
    }
}
