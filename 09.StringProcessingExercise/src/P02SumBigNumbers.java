import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02SumBigNumbers {
    public static void main(String[] args) throws IOException { //TODO 80/100
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //must solve without BigInteger/BigDecimal

        StringBuilder longerNum = new StringBuilder().append(reader.readLine());
        StringBuilder shorterNum = new StringBuilder().append(reader.readLine());

        if (longerNum.length() < shorterNum.length()) {
            String tempStr = longerNum.toString();
            longerNum.delete(0, longerNum.length()).append(shorterNum.toString());
            shorterNum.delete(0, shorterNum.length()).append(tempStr);
        }

        longerNum.reverse();
        shorterNum.reverse();

        int addition = 0;

        int i = 0;
        for (i = 0; i < shorterNum.length(); i++) {
            int longerNumCurrentDigit = Integer.parseInt("" + longerNum.charAt(i));
            int shorterNumCurrentDigit = Integer.parseInt("" + shorterNum.charAt(i));
            int sum = longerNumCurrentDigit + shorterNumCurrentDigit + addition;

            longerNum.replace(i, i + 1, "" + (sum % 10));
            addition = sum / 10;
        }

        while (addition > 0) {
            if (i == longerNum.length()) {
                //append
                longerNum.append(addition);
                break;
            } else {
                //replace
                int longerNumCurrentDigit = Integer.parseInt("" + longerNum.charAt(i));
                int sum = longerNumCurrentDigit + addition;
                longerNum.replace(i, i + 1, "" + (sum % 10));
                addition = sum / 10;
                i++;
            }
        }

        longerNum.reverse();
        System.out.println(longerNum);

        //main ends here
    }
}
