import java.util.Arrays;
import java.util.Scanner;

public class P02EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(scanner.nextLine());
        String[] names = new String[numberOfNames];
        for (int i = 0; i < numberOfNames; i++) {
            names[i] = scanner.nextLine();
        }

        int[] encodedNames = new int[numberOfNames];
        for (int i = 0; i < encodedNames.length; i++) {
            encodedNames[i] = encryptName(names[i]);
        }

        Arrays.sort(encodedNames); // must be sorted alphabetically
        System.out.println(Arrays.toString(encodedNames)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n"));

        //main ends here
    }

    static int encryptName(String name) {
        String vowels = "aeiou";
        int result = 0;

        for (int i = 0; i < name.length(); i++) {
            if (vowels.contains(("" + name.charAt(i)).toLowerCase())) {
                result += name.charAt(i) * name.length();
            } else {
                result += name.charAt(i) / name.length(); // celochisleno delenie tiabva da e
            }
        }

        return result;
    }

}
