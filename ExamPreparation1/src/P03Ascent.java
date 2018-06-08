import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03Ascent {
    public static void main(String[] args) throws IOException { // TODO 60/100
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(_|,)(?<word>[A-z]+)?(?<digit>[0-9])");

        String input = reader.readLine();
        while (!"Ascend".equals(input)) {

            while (true) {
                Matcher matcher = pattern.matcher(input);
                while (matcher.find()) {
                    StringBuilder sb = new StringBuilder();

                    String word = matcher.group("word");
                    int digit = Integer.parseInt(matcher.group("digit"));

                    for (int i = 0; i < word.length(); i++) {
                        char updatedCharacter = '\0';
                        if (matcher.group(0).startsWith(",")) {
                            updatedCharacter = (char) (word.charAt(i) + digit);
                        } else {
                            updatedCharacter = (char) (word.charAt(i) - digit);
                        }
                        sb.append(updatedCharacter);
                    }

                    input = input.replaceFirst(matcher.group(0), sb.toString());
                }
                matcher = pattern.matcher(input);
                if (!matcher.find()) {
                    break;
                }
            }


            System.out.println(input);

            input = reader.readLine();
        }

        //main ends here
    }
}
