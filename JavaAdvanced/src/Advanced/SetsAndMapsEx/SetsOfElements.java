package Advanced.SetsAndMapsEx;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetSize = size[0];
        int secondSetSize = size[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 1; i <= firstSetSize; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 1; i <= secondSetSize; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(n -> System.out.print(n + " "));
    }
}
