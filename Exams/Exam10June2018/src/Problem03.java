import javafx.css.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> organismGenomeSize = new LinkedHashMap<>();// later must be sorted by genome size, or stay in input order

        Pattern genomePattern = Pattern.compile("^(?<body>[a-z!@#$?]+)=(?<length>[0-9]+)--(?<genomeCount>[0-9]+)<<(?<organism>.+)$");
        // .+ might not be 100% correct

        String input;
        while (!"Stop!".equals(input = reader.readLine())) {
            Matcher matcher = genomePattern.matcher(input);

            if (!matcher.find()) {
                continue;
            }

            String body = matcher.group("body");
            int length = Integer.parseInt(matcher.group("length"));
            int currentGenomeSize = Integer.parseInt(matcher.group("genomeCount"));
            String organism = matcher.group("organism");

            if (!isRightLength(body, length)) {
                continue;
            }

            if (!organismGenomeSize.containsKey(organism)) {
                organismGenomeSize.put(organism, 0);
            }
            int previousGenomeSize = organismGenomeSize.get(organism);
            organismGenomeSize.put(organism, previousGenomeSize + currentGenomeSize);
        }
        reader.close();

        organismGenomeSize.entrySet().stream()
                .sorted((kvp1, kvp2) -> {
                    return kvp2.getValue().compareTo(kvp1.getValue());
                }).forEach(kvp -> {
            System.out.printf("%s has genome size of %d%n", kvp.getKey(), kvp.getValue());
        });

        //main ends here
    }

    static boolean isRightLength(String body, int length) {
        Pattern lowerCaseLettersPattern = Pattern.compile("[a-z]");
        Matcher matcher = lowerCaseLettersPattern.matcher(body);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count == length;
    }

}
