import java.util.Scanner;

public class P02TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt(); //A
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt(); //B
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt(); //C
        int y3 = scanner.nextInt();

        if (!isATriangle(x1, y1, x2, y2, x3, y3)) {
            System.out.println(0);
            return;
        }

        double triangleArea = Math.abs(( x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) ) / 2.0);
        System.out.print((int)triangleArea);
        //main ends here
    }

    static boolean isATriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x1 == x2 && x1 == x3) {
            return false;
        }
        if (y1 == y2 && y1 == y3) {
            return false;
        }
        if (x1 == y1 && x2 == y2 && x3 == y3) {
            return false;
        }
        return true;

    }

}
