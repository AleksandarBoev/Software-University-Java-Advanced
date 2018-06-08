import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        String input = reader.readLine();
        while (!"Here We Go".equals(input)) {
            int[] coordinates = Arrays.stream(input.split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
            int x1 = coordinates[0];
            int y1 = coordinates[1];
            int x2 = coordinates[2];
            int y2 = coordinates[3];

            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    matrix[row][col]++;
                }
            }

            input = reader.readLine();
        }
        reader.close();

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);

        //main ends here
    }
}
