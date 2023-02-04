package Advanced.StacksQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
//        String numbers = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        ArrayDeque<Character> stack = new ArrayDeque<>();

        Arrays.stream(numbersArr).forEach(stack::push);
//        for (char number : numbers.toCharArray()) {
//            stack.push(number);
//        }

        while (stack.size() > 0 ) {
            System.out.print(stack.pop() + " ");
//            System.out.print(stack.pop());
        }
    }
}
