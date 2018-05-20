import java.util.*;

public class P16PoisonousPlants { // TODO come up with a smarter solution (77/100)
    public static void main(String[] args) {
        //7
        //6 5 8 4 7 10 9
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split("\\s+");

        Integer[] pesticides = new Integer[numberOfPlants];

        for (int i = 0; i < tokens.length; i++) {
            pesticides[i] = Integer.parseInt(tokens[i]);
        }

        int dayCount = 0;
        while (true) {
            boolean[] deadPlants = new boolean[pesticides.length];
            for (int i = 0; i < pesticides.length - 1; i++) {
                if (pesticides[i + 1] > pesticides[i]) {
                    deadPlants[i + 1] = true;
                }
            }

            List<Integer> survivors = new ArrayList<>();
            boolean atleastOneDead = false;
            for (int i = 0; i < pesticides.length; i++) {
                if (!deadPlants[i]) {
                    survivors.add(pesticides[i]);
                } else {
                    atleastOneDead = true;
                }
            }

            if (atleastOneDead) {
                dayCount++;
                pesticides = new Integer[survivors.size()];
                pesticides = survivors.toArray(pesticides);
            } else {
                break;
            }
        }

        System.out.println(dayCount);

        //main ends here
    }
}
