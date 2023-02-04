package Advanced.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (n1, n2) -> {
          if (n1 % 2 == 0 && n2 % 2 != 0) {
              return -1;
          } else if (n1 % 2 != 0 && n2 % 2 == 0) {
              return 1;
          } else {
              return n1.compareTo(n2);
          }
        };

        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}
