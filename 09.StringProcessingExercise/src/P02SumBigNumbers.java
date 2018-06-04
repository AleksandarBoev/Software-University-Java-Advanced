import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02SumBigNumbers {
    public static void main(String[] args) throws IOException { //TODO not done
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //must solve without BigInteger/BigDecimal

        String longerNum = reader.readLine();
        String num = reader.readLine();

        if (longerNum.length() < num.length()) {
            String tempStr = longerNum;
            longerNum = num;
            num = tempStr;
        }

        StringBuilder result = new StringBuilder();
        
        int addition = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            int numDigit = Integer.parseInt(num.charAt(i) + " ");
            int longerNumDigit = Integer.parseInt(longerNum.charAt(i) + " ");
            int sum = numDigit + longerNumDigit;

            result.append(sum % 10 + addition);
            addition = sum / 10;
        }

//        while (addition > 0) {
//            result.append();
//        }
        //main ends here
    }
}
