import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P09MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int numberOfCommands = Integer.parseInt(reader.readLine());
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = reader.readLine().split(" ");
            int command = Integer.parseInt(commands[0]);

            switch (command) {
                case 1:
                    int valueToPush = Integer.parseInt(commands[1]);
                    if (valueToPush > maxValue) {
                        maxValue = valueToPush;
                    }
                    stack.push(valueToPush);
                    break;

                case 2:
                    if (stack.pop() == maxValue) {
                        maxValue = getMaxValue(stack);
                    }
                    break;

                case 3:
                    sb.append(maxValue).append(System.lineSeparator()); // if I use System.out.println() I will hit timelimit on last 2 tests
                    break;
            }
        }
        reader.close();

        System.out.println(sb);

        //main ends here

    }

    static int getMaxValue(ArrayDeque<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;

        for (Integer value:stack) {
            if (value > maxValue) {
                maxValue = value;
            }
        }


        return maxValue;
    }


}
