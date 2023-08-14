package Advanced.ExamPreparationSecond.FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int flowersLeft = 0;
        
        while(!lilies.isEmpty() && !roses.isEmpty()) {
            int firstRose = roses.poll();
            int lastLilie = lilies.pop();

            int sum = lastLilie + firstRose;

            if (sum == 15) {
                wreaths++;
            } else if (sum > 15) {
                lilies.push(lastLilie - 2);
                roses.push(firstRose);
            } else if (sum < 15) {
                flowersLeft += sum;
            }
        }

        wreaths += flowersLeft / 15;

        String result = wreaths >= 5
                ? String.format("You made it, you are going to the competition with %d wreaths!", wreaths)
                : String.format("You didn't make it, you need %d wreaths more!", 5 - wreaths);

        System.out.println(result);
    }
}
