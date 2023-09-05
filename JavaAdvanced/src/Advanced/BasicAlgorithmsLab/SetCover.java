package Advanced.BasicAlgorithmsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SetCover {
    private static List<List<Integer>> chosenSets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().split(": ")[1];

        List<Integer> universe = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int numberOfSets = Integer.parseInt(scanner.nextLine().split(": ")[1]);

        List<List<Integer>> setList = new ArrayList<>();

        for (int i = 1; i <= numberOfSets; i++) {
            List<Integer> set = Arrays.stream(scanner.nextLine().split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            setList.add(set);
        }

        setList.sort((s1, s2) -> s2.size() - s1.size());

        addSets(setList, universe);

        StringBuilder result = new StringBuilder();
        result.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        chosenSets.forEach(set -> result.append("{ ")
                .append(String.valueOf(set).replaceAll("\\[|]", ""))
                .append(" }").append(System.lineSeparator()));

        System.out.println(result);
    }

    private static void addSets(List<List<Integer>> setList, List<Integer> numbers) {
        for (int i = 0; i < setList.size(); i++) {
            boolean isElementExist = false;

            List<Integer> set = setList.get(i);

            for (int j = 0; j < set.size(); j++) {
                Integer number = set.get(j);

                if (!numbers.isEmpty() && numbers.contains(number)) {
                    numbers.remove(number);
                    isElementExist = true;
                }
            }

            if (isElementExist) {
                chosenSets.add(set);
            }
        }
    }
}