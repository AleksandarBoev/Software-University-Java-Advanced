import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P02LittleAlchemy {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> queueStones = new ArrayDeque<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] stones = Arrays.stream(reader.readLine().split(" ")).map(x -> Integer.parseInt(x)).toArray(size -> new Integer[size]);
        queueStones.addAll(Arrays.asList(stones));

        int gold = 0;

        String input = reader.readLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int commandNumber = Integer.parseInt(tokens[2]);

            if ("Apply".equals(command)) {
                for (int i = 0; i < commandNumber; i++) {
                    if (queueStones.isEmpty())
                        break;

                    int poppedStone = queueStones.pop() - 1;
                    if (poppedStone > 0) {
                        queueStones.add(poppedStone);
                    } else {
                        gold++;
                    }
                }
            } else if ("Air".equals(command)) {
                if (gold != 0) {
                    queueStones.add(commandNumber);
                    gold--;
                }
            }

            input = reader.readLine();
        }

        while (!queueStones.isEmpty()) {
            System.out.print(queueStones.pop() + " ");
        }
        System.out.println();
        System.out.print(gold);

        //main ends here
    }
}
