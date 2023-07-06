package Advanced.IteratorsAndComparatorsEx.StackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StackIterator<Integer> stackIterator = new StackIterator<>();

        Pattern pattern = Pattern.compile("(?<commandName>[A-Z][a-z]+) (?<numbers>[\\d, ]+)");

        while (!input.equals("END")) {

            if (input.contains("Push")) {
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    Arrays.stream(matcher.group("numbers").split(", "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
                            .forEach(stackIterator::push);
                }
            } else {
                try {
                    stackIterator.pop();
                } catch (IllegalStateException e) {
                    System.out.println("No elements");
                }
            }

            input = scanner.nextLine();
        }

        List<Integer> numbers = new ArrayList<>();

        try {
            stackIterator.forEach(numbers::add);
            for (int i = 1; i <= 2; i++) {
                numbers.forEach(System.out::println);
            }
        } catch (IllegalStateException e) {}
    }
}
