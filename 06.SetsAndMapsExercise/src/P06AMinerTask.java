import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> resourceQuantity = new LinkedHashMap<>();

        String resource;
        while(!"stop".equals(resource = scanner.nextLine())) {
            long quantity = Long.parseLong(scanner.nextLine());

            if (!resourceQuantity.containsKey(resource)) {
                resourceQuantity.put(resource, 0L);
            }

            resourceQuantity.put(resource, resourceQuantity.get(resource) + quantity);
        }

        for (Map.Entry<String, Long> kvp : resourceQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", kvp.getKey(), kvp.getValue());
        }

        //main ends here
    }
}
