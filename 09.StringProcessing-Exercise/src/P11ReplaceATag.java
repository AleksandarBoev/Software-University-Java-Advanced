import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(<a)\\s+href=\\s*[^>]+?(>)\\s*.*?\\s*(<\\/a>)");
        Matcher matcher;
        StringBuilder sb = new StringBuilder();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            sb.append(input).append(System.lineSeparator());
        }

        String text = sb.toString();
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            String toBeReplaced = matcher.group();
            String replacement = toBeReplaced.replaceFirst(matcher.group(1), "[URL");
            replacement = replacement.replaceFirst(matcher.group(2), "]");
            replacement = replacement.replaceFirst(matcher.group(3), "[/URL]");
            text = text.replace(toBeReplaced, replacement);
        }

        System.out.println(text);

        //main ends here
    }
}
