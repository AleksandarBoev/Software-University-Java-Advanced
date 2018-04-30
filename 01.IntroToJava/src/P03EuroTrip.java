import java.math.BigDecimal;
import java.util.Scanner;

public class P03EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantity = Double.parseDouble(scanner.nextLine());
        BigDecimal priceLeva = new BigDecimal(quantity * 1.2);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceGermanMarks = exchangeRate.multiply(priceLeva);
        System.out.printf("%.2f marks", priceGermanMarks);
    }
}
