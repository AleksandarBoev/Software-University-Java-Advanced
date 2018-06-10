import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern cratePattern = Pattern.compile("\\[.*?\\]");
        Matcher matcher;

        int cratesFound = 0;

        Set<String> allInputs = new LinkedHashSet<>();

        String input;
        while (!"Collect".equals(input = reader.readLine())) {
            allInputs.add(input);
            matcher = cratePattern.matcher(input);
            while (matcher.find()) {
                cratesFound++;
            }
        }

        int N = cratesFound / allInputs.size();

        String regex = String.format("\\[#(?<tag>[a-z]{%1$d}|[0-9]{%1$d})(?<body>[A-z0-9 ]+?)#(\\1)\\]", N);
        Pattern validCratesPattern = Pattern.compile(regex);

        int validCratesCount = 0;
        int totalFood = 0;
        int totalDrinks = 0;

        for (String currentInput : allInputs) {
            matcher = validCratesPattern.matcher(currentInput);

            while (matcher.find()) {
                validCratesCount++;
                String tag = matcher.group("tag");
                try {
                    Integer.parseInt(tag);
                    totalFood += calculateFood(matcher.group("body"), tag.length());
                } catch (NumberFormatException nfe) {
                    totalDrinks += calculateDrinks(matcher.group("body"), matcher.group("tag"));
                }
            }
        }

        if (validCratesCount == 0) {
            System.out.println("No supplies found!");
            return;
        }

        System.out.printf("Number of supply crates: %d%n", validCratesCount);
        System.out.printf("Amount of food collected: %d%n", totalFood);
        System.out.printf("Amount of drinks collected: %d%n", totalDrinks);
        //main ends here
    }

    private static int calculateDrinks(String body, String tag) {
        int sumBody = getAsciiCodeSum(body);

        int sumTag = getAsciiCodeSum(tag);

        return sumBody * sumTag;
    }

    private static int calculateFood(String body, int supplyTagLength) {
        String[] uniqueChars = Arrays.stream(body.split("")).distinct().toArray(size -> new String[size]);

        int sum = getAsciiCodeSum(String.join("", uniqueChars));

        return sum * supplyTagLength;
    }

    private static int getAsciiCodeSum(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += text.charAt(i);
        }

        return sum;
    }

}
