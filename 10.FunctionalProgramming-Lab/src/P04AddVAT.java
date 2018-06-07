import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class P04AddVAT {
    public static void main(String[] args) throws IOException {
        Consumer<String> readAndPrintWithVAT = input -> { // not a good practise to make an all in one function
            String[] tokens = input.split(", ");
            StringBuilder sb = new StringBuilder().append("Prices with VAT:").append(System.lineSeparator());

            for (int i = 0; i < tokens.length; i++) {
                double priceWithVAT = Double.parseDouble(tokens[i]) * 1.2;
                sb.append(String.format("%.2f", priceWithVAT)).append(System.lineSeparator());
            }

            System.out.print(sb);
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        readAndPrintWithVAT.accept(input);
        //main ends here
    }
}
