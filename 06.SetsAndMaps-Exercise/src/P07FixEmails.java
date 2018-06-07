import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nameEmail = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = scanner.nextLine())) {
            String email = scanner.nextLine();
            String domain = email.substring(email.length() - 4, email.length());

            if (domain.toLowerCase().contains("uk")
                    || domain.toLowerCase().contains("us")
                    || domain.toLowerCase().contains("com")) {
                continue;
            }

            nameEmail.put(name, email);
        }

        for (String currentName : nameEmail.keySet()) {
            System.out.printf("%s -> %s%n", currentName, nameEmail.get(currentName));
        }

        //main ends here
    }
}
