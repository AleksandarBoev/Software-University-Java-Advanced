import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09ByteParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(reader.readLine());
        int[] numbers = new int[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        String commands;
        while (!(commands = reader.readLine()).equals("party over")) {
            int command = Integer.parseInt(commands.split(" ")[0]);
            int position = Integer.parseInt(commands.split(" ")[1]);
            int mask = 1 << position;

            switch (command) {
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ mask;
                    }
                    break;

                case 0:
                    mask = ~mask;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask;
                    }
                    break;

                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask;
                    }
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //main ends here
    }
}
