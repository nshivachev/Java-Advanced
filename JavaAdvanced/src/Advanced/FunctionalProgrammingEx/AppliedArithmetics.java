package Advanced.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        UnaryOperator<List<Integer>> function;
        Consumer<Integer> print = n -> System.out.printf("%d ", n);

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    function = l -> l.stream().map(n -> n + 1).collect(Collectors.toList());
                    numbers = function.apply(numbers);
                    break;
                case "multiply":
                    function = l -> l.stream().map(n -> n * 2).collect(Collectors.toList());
                    numbers = function.apply(numbers);
                    break;
                case "subtract":
                    function = l -> l.stream().map(n -> n - 1).collect(Collectors.toList());
                    numbers = function.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(print);
                    System.out.println();
                    break;
                default:
                    System.out.println("No such command!");
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
