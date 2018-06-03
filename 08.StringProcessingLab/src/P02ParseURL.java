import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("://");

        if (tokens.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = tokens[0];

        int serverIndexEnd = tokens[1].indexOf('/');
        String server = tokens[1].substring(0, serverIndexEnd);

        String resources = tokens[1].substring(serverIndexEnd + 1, tokens[1].length());

        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s", resources);

        //main ends here
    }
}
