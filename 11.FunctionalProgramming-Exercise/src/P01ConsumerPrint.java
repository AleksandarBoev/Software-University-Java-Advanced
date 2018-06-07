import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) throws IOException {
        Consumer<String> printWords = text -> {
            String[] words = text.split(" ");
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
            }
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printWords.accept(reader.readLine());
        reader.close();

        //main ends here
    }
}
