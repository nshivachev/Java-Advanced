package Advanced.StacksQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [] numbersArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstDeque = new ArrayDeque<>();
        Arrays.stream(numbersArr).forEach(firstDeque::offer);

        int days = 0;

        while (true) {
            ArrayDeque<Integer> secondDeque = new ArrayDeque<>();
            ArrayDeque<Integer> thirdDeque = new ArrayDeque<>();

            boolean isDying = false;

            while (!firstDeque.isEmpty()) {
                if (firstDeque.size() > 1) {
                    int leftElement = firstDeque.poll();
                    int rightElement = firstDeque.poll();
                    firstDeque.push(rightElement);

                    if (leftElement < rightElement) {
                        thirdDeque.offer(rightElement);
                        if (!thirdDeque.contains(leftElement) && !secondDeque.contains(leftElement)) {
                            secondDeque.offer(leftElement);
                        }
                        isDying = true;
                    } else if (leftElement > rightElement){
                        if (!thirdDeque.contains(leftElement) && !secondDeque.contains(leftElement)) {
                            secondDeque.offer(leftElement);
                        }
                        if (!thirdDeque.contains(rightElement) && !secondDeque.contains(rightElement)) {
                            secondDeque.offer(rightElement);
                        }
                    } else if (leftElement == rightElement) {
                        if (!secondDeque.isEmpty()) {
                            if (secondDeque.peek() != leftElement) {
                                secondDeque.offer(leftElement);
                                secondDeque.offer(rightElement);
                            }
                        }
                    }
                } else {
                    int lastElement = firstDeque.poll();
                    if (!thirdDeque.contains(lastElement) && !secondDeque.contains(lastElement)) {
                        secondDeque.offer(lastElement);
                    }
                }
            }
            if (!isDying) {
                break;
            }
            firstDeque = secondDeque;
            days++;
        }
        System.out.println(days);
    }
}
