package Advanced.FunctionalProgrammingLab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static  class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> persons = IntStream.range(0, n)
                .mapToObj(i -> readPerson(scanner))
                .collect(Collectors.toList());


        String condition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

        Predicate<Person> predicate = getPredicate(condition, ageFilter);

        persons = filterPersons(persons, predicate);

        Consumer<Person> printer = getPrinter(outputFormat);

        persons.forEach(printer);
    }

    private static Person readPerson(Scanner scanner) {
        String input = scanner.nextLine();

        String name = input.split(", ")[0];
        int age = Integer.parseInt(input.split(", ")[1]);

        return new Person(name, age);
    }

    private static Consumer<Person> getPrinter(String outputFormat) {
        switch (outputFormat) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format: " + outputFormat);
        }
    }

    public static  Predicate<Person> getPredicate(String condition, int ageFilter) {
        switch (condition) {
            case "younger":
                return p -> p.age <= ageFilter;
            case "older":
                return p -> p.age >= ageFilter;
            default:
                throw new IllegalArgumentException("Unknown format " + condition + " " + ageFilter);
        }
    }

    public static List<Person> filterPersons(List<Person> persons, Predicate<Person> predicate) {
        return persons.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
