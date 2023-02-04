package Advanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCaseWords = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        Function<List<String>, Integer> countElements = List::size;

        System.out.println(countElements.apply(upperCaseWords));

        System.out.println(String.join(System.lineSeparator(), upperCaseWords));
    }
}
