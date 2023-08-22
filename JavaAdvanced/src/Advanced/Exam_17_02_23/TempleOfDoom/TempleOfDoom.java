package Advanced.Exam_17_02_23.TempleOfDoom;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer>  substanceStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substanceStack::push);

        List<Integer> challengesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substanceStack.isEmpty() && !challengesList.isEmpty()) {
            int firstTool = toolsQueue.poll();
            int lastSubstance =  substanceStack.pop();
            int result = firstTool * lastSubstance;

            if (challengesList.contains(result)) {
                challengesList.remove((Integer) result);
            } else {
                toolsQueue.offer(firstTool + 1);

                if (lastSubstance - 1 > 0) {
                    substanceStack.push(lastSubstance - 1);
                }
            }
        }

        if (challengesList.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!toolsQueue.isEmpty()) {
            System.out.println("Tools: " + toolsQueue.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!substanceStack.isEmpty()) {
            System.out.println("Substances: " + substanceStack.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!challengesList.isEmpty()) {
            System.out.println("Challenges: " + challengesList.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
