import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
//test input:
//9
//1 97
//2
//1 20
//2
//1 26
//1 20
//3
//1 91
//3

public class P09MaximumElement { //TODO optimize
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

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
                    System.out.println(getMaxValue(stack));
                    break;
            }
        }



        //main ends here

    }

    static Integer getMaxValue(ArrayDeque<Integer> stack) {
        Integer maxValue = Integer.MIN_VALUE;
//        ArrayDeque<Integer> temporaryStack = stack.clone();
//
//        if (temporaryStack.isEmpty())
//            return null;
//
//        while (!temporaryStack.isEmpty()) {
//            int value = temporaryStack.pop();
//            if (value > maxValue) {
//                maxValue = value;
//            }
//        }
//        for (int i = 0; i < stack.size(); i++) {
//            int currentValue = stack.peek();
//            if (currentValue > maxValue) {
//                maxValue = currentValue;
//            }
//
//            stack.add(stack.remove());
//        }
        for (Integer value:stack) {
            if (value > maxValue) {
                maxValue = value;
            }
        }


        return maxValue;
    }


}
