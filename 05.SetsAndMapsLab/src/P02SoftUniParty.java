import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new HashSet<>();

        String input;
        while (!"PARTY".equals(input = scanner.nextLine())) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
        }

        while (!"END".equals(input = scanner.nextLine())) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }
        }

        System.out.println(regularGuests.size() + vipGuests.size());

        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }

        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }

        //main ends here
    }
}
