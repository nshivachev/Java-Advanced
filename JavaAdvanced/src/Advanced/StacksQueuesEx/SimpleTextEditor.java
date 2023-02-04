package Advanced.StacksQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> commandsStack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            if (command.equals("1")) {
                commandsStack.push(command);
                stack.push(String.valueOf(text));
                text.append(input.split("\\s+")[1]);
            } else if (command.equals("2")) {
                commandsStack.push(command);
                stack.push(String.valueOf(text));
                int value = Integer.parseInt(input.split("\\s+")[1]);
                for (int j = 1; j <= value; j++) {
                    text.deleteCharAt(text.length() - 1);
                }
            } else if (command.equals("3")) {
                int value = Integer.parseInt(input.split("\\s+")[1]);
                System.out.println(text.charAt(value - 1));
            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    text = new StringBuilder(stack.pop());
                }
            }
        }
    }
}
