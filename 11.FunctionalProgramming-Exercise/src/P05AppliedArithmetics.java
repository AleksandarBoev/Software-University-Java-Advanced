import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class P05AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Long[] numbers = Arrays.stream(reader.readLine().split(" ")).map(x -> Long.parseLong(x)).toArray(size -> new Long[size]);

        Consumer<Long[]> addOne = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i]++;
            }
        };

        Consumer<Long[]> multiplyByTwo = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i] *= 2;
            }
        };

        Consumer<Long[]> subtractByOne = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i]--;
            }
        };

        Consumer<Long[]> printArray = array -> {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        };

        BiConsumer<String, Long[]> executeCommand = (command, longArray) -> {
            switch (command) {
                case "add":
                    addOne.accept(longArray);
                    break;

                case "multiply":
                    multiplyByTwo.accept(longArray);
                    break;

                case "subtract":
                    subtractByOne.accept(longArray);
                    break;

                case "print":
                    printArray.accept(longArray);
                    break;
            }
        };

        String input;
        while (!"end".equals(input = reader.readLine())) {
            executeCommand.accept(input, numbers);
        }

        reader.close();

        //main ends here
    }
}
