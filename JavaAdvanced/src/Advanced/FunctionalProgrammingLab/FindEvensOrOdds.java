package Advanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int low = range[0];
        int up = range[1];

        String condition = scanner.nextLine();

        Predicate<Integer> predicate = condition.equals("odd") ? n -> n % 2 != 0 : n -> n % 2 == 0;

        IntStream.rangeClosed(low, up)
                .boxed()
                .filter(predicate)
                .collect(Collectors.toList())
                .forEach(n -> System.out.print(n + " "));
    }
}
