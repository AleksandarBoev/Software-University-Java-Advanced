import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10XBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] binaryNum = new String[8];
        for (int i = 0; i < 8; i++) {
            binaryNum[i] = String.format("%32s", Integer.toBinaryString(Integer.parseInt(reader.readLine()))).replace(' ', '0');
        }

        int xCounter = 0;

        for (int currentBinaryNum = 1; currentBinaryNum < 7; currentBinaryNum++) {
            for (int currentBit = 0; currentBit < binaryNum[currentBinaryNum].length() - 2; currentBit++) {
                String formString = "" +
                        binaryNum[currentBinaryNum].charAt(currentBit) +
                        binaryNum[currentBinaryNum].charAt(currentBit + 1) +
                        binaryNum[currentBinaryNum].charAt(currentBit + 2);
                if (formString.equals("010")) {
                    String formUpperPart = "" +
                            binaryNum[currentBinaryNum - 1].charAt(currentBit) +
                            binaryNum[currentBinaryNum - 1].charAt(currentBit + 1) +
                            binaryNum[currentBinaryNum - 1].charAt(currentBit + 2);
                    String formLowerPart = "" +
                            binaryNum[currentBinaryNum + 1].charAt(currentBit) +
                            binaryNum[currentBinaryNum + 1].charAt(currentBit + 1) +
                            binaryNum[currentBinaryNum + 1].charAt(currentBit + 2);
                    if (formUpperPart.equals("101") && formLowerPart.equals("101")) {
                        xCounter++;
                    }
                }
            }
        }

        System.out.println(xCounter);

        //main ends here
    }
}
