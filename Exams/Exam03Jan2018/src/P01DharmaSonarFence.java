import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01DharmaSonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"Reprogram".equals(input = reader.readLine())) {
            int inputNumber = Integer.parseInt(input);
            System.out.println(reprogram(inputNumber));
        }

        reader.close();
        //main ends here
    }

    static long reprogram(int initialNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%32s", Integer.toBinaryString(initialNumber)).replace(" ", "0"));

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                if (sb.charAt(i) == '0') {
                    sb.replace(i, i + 2, "11");
                } else {
                    sb.replace(i, i + 2, "00");
                }
                i++;
            }
        }
        return Long.parseLong(sb.toString(), 2);
    }

}
