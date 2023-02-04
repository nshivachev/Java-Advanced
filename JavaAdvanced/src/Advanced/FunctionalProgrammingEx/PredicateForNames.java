package Advanced.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> predicate = name -> name.length() <= length;

        Consumer<String> print = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate)
                .collect(Collectors.toList())
                .forEach(print);
    }
}
