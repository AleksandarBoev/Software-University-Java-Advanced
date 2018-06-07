import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> namePhonenumber = new HashMap<>();

        String contactInfo;
        while (!"search".equals(contactInfo = scanner.nextLine())) {
            String[] tokens = contactInfo.split("-");
            namePhonenumber.put(tokens[0], tokens[1]);
        }

        String name;
        while (!"stop".equals(name = scanner.nextLine())) {
            if (!namePhonenumber.containsKey(name)) {
                System.out.printf("Contact %s does not exist.%n", name);
            } else {
                System.out.printf("%s -> %s%n", name, namePhonenumber.get(name));
            }
        }

        //main ends here
    }
}
