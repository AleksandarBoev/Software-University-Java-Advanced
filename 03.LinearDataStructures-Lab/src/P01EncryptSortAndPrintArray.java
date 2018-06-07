import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = Integer.parseInt(scanner.nextLine());
        String[] names = new String[arrayLength];
        int[] encryptedNames = new int[arrayLength];

        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();
            encryptedNames[i] = encryptedNameValue(names[i]);
        }

        Arrays.sort(encryptedNames);
        for (int i = 0; i < encryptedNames.length; i++) {
            System.out.println(encryptedNames[i]);
        }
        //main ends here
    }

    static int encryptedNameValue(String name) {
        int value = 0;

        for (int i = 0; i < name.length(); i++) {
            if (isVowel(name.charAt(i))) {
                value += name.charAt(i) * name.length();
            } else {
                value += name.charAt(i) / name.length();
            }
        }

        return value;
    }

    static boolean isVowel(char character) {
        if ("AEIOUaeiou".contains("" + character)) {
            return true;
        } else {
            return false;
        }

    }

}
