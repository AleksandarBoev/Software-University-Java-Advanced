import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P14SimpleTextEditor {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //test input:
        //8
        //1 abc
        //3 3
        //2 3
        //1 xy
        //3 2
        //4
        //4
        //3 1
        //expected output:
        //c
        //y
        //a

        ArrayDeque<String> stateOfStringStack = new ArrayDeque<>(); // every change to the string will be pushed and the command 4 will pop the last change
        StringBuilder stringBuilder = new StringBuilder("");
        stateOfStringStack.push(stringBuilder.toString());

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            int currentCommand = Integer.parseInt(tokens[0]);

            switch (currentCommand) {
                case 1:
                    stringBuilder.append(tokens[1]);
                    stateOfStringStack.push(stringBuilder.toString());
                    break;

                case 2:
                    int deleteLength = Integer.parseInt(tokens[1]);
                    stringBuilder.delete(stringBuilder.length() - deleteLength, stringBuilder.length());
                    stateOfStringStack.push(stringBuilder.toString());
                    break;

                case 3:
                    int charPosition = Integer.parseInt(tokens[1]) - 1;
                    System.out.println(stringBuilder.charAt(charPosition));
                    break;

                case 4:
                    stringBuilder.delete(0, stringBuilder.length());
                    stateOfStringStack.pop();
                    stringBuilder.append(stateOfStringStack.peek());
                    break;
            }
        }

        //main ends here
    }
}
