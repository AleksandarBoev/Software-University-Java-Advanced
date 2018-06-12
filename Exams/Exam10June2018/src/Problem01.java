import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problemsQueue = new ArrayDeque<>(); //in the beginning elements are added like a stack, but readded like a queue
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            problemsQueue.push(reader.readLine());
        }

        for (int i = 0; i < candidatesCount; i++) {
            String name = reader.readLine();
            if (nameIsValid(name)) {
                candidatesQueue.add(name);
            }
        }

        while (!problemsQueue.isEmpty() && candidatesQueue.size() != 1) {
            String currentProblem = problemsQueue.pop();
            String currentCandidate = candidatesQueue.pop();

            if (problemIsSolved(currentProblem, currentCandidate)) {
                System.out.printf("%s solved %s.%n", currentCandidate, currentProblem);
                candidatesQueue.add(currentCandidate);
            } else {
                System.out.printf("%s failed %s.%n", currentCandidate, currentProblem);
                problemsQueue.add(currentProblem);
            }
        }

        if (candidatesQueue.size() == 1) {
            System.out.printf("%s gets the job!", candidatesQueue.pop());
        } else {
            System.out.println(String.join(", ", candidatesQueue));
        }

        reader.close();
        //main ends here
    }

    static int getCharactersSum(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += text.charAt(i);
        }

        return sum;
    }

    static boolean problemIsSolved(String problem, String candidate) {
        return getCharactersSum(candidate) > getCharactersSum(problem);
    }

    static boolean nameIsValid(String candidateName) { //can a name have anything else other than letters?
        Pattern namePattern = Pattern.compile("\\b[A-Z][a-z]+\\b\\s[A-Z][a-z]+\\b");
        Matcher matcher = namePattern.matcher(candidateName);
        return matcher.find();
    }

}
