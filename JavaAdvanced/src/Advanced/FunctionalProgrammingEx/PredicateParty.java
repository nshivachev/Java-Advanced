package Advanced.FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peopleList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            String currentCommand = tokens[0];
            Predicate<String> predicate = getPredicate(tokens);

            if (currentCommand.equals("Double")) {
                List<String> peopleToAdd = new ArrayList<>();
                peopleList.stream().filter(predicate).forEach(peopleToAdd::add);
                peopleList.addAll(peopleToAdd);
            } else {
                peopleList.removeIf(predicate);
            }
            command = scanner.nextLine();
        }

        if (peopleList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(peopleList);
            System.out.println(String.join(", ", peopleList) + " are going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        String filterName = tokens[1];
        String filterCriteria = tokens[2];
        Predicate<String> predicate = null;

        switch (filterName) {
            case "StartsWith":
                predicate = name -> name.startsWith(filterCriteria);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(filterCriteria);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(filterCriteria);
                break;
        }
        return predicate;
    }
}
