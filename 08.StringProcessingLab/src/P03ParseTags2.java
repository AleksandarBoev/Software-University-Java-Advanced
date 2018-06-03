import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03ParseTags2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder().append(reader.readLine());

        while (sb.indexOf("<upcase>") != -1) {
            int startDelete = sb.indexOf("<upcase>");
            int endDelete = sb.indexOf("</upcase>") + "</upcase>".length();

            String wordTobeReplaced = sb.substring(startDelete + "<upcase>".length(), endDelete - "</upcase>".length());
            sb.delete(startDelete, endDelete);
            sb.insert(startDelete, wordTobeReplaced.toUpperCase());
        }
        System.out.println(sb.toString());
        //main ends here
    }
}
