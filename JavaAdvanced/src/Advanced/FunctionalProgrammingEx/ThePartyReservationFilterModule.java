package Advanced.FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> inputList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");

            String command = tokens[0];
            String filterName = tokens[1];
            String filterCriteria = tokens[2];

            if (command.equals("Add filter")) {
                inputList.add(filterName + ";" + filterCriteria);
            } else if (command.equals("Remove filter")) {
                inputList.removeIf(el -> el.equals(filterName + ";" + filterCriteria));
            }
            input = scanner.nextLine();
        }

        inputList.forEach(el -> {
            Predicate<String> predicate = getPredicate(el.split(";"));
            guestList.removeIf(predicate);
        });

        guestList.forEach(g -> System.out.print(g + " "));
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate;
        String filterName = tokens[0];
        String filterCriteria = tokens[1];

        switch (filterName) {
            case "Starts with":
                predicate = guest -> guest.startsWith(filterCriteria);
                break;
            case "Ends with":
                predicate = guest -> guest.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = guest -> guest.length() == Integer.parseInt(filterCriteria);
                break;
            case "Contains":
                predicate = guest -> guest.contains(filterCriteria);
                break;
            default:
                throw new IllegalArgumentException("Unknown format " + filterName + " " + filterCriteria);
        }
        return predicate;
    }
}
