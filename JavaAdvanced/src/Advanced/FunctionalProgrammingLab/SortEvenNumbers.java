package Advanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> unsortedOddNumbers = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(unsortedOddNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(unsortedOddNumbers
                .stream()
                .sorted(Integer::compareTo)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
