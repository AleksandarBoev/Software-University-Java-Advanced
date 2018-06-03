import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.

public class P03ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while(input.contains("<upcase>")) {
            int startReplaceIndex = input.indexOf("<upcase>") + "<upcase>".length();
            int stopReplaceIndex = input.indexOf("</upcase>");

            String wordToBeReplaced = input.substring(startReplaceIndex, stopReplaceIndex);
            input = input.replaceFirst(wordToBeReplaced, wordToBeReplaced.toUpperCase());
            input = input.replaceFirst("<upcase>", "");
            input = input.replaceFirst("</upcase>", "");
        }

        System.out.println(input);

        //main ends here
    }
}
