package Advanced.StacksQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String symbol : input) {
            Matcher matcher = pattern.matcher(symbol);
            if (matcher.find()) {
                queue.offer(symbol);
            } else {
                if (stack.isEmpty()) {
                    stack.push(symbol);
                } else {
                    String lastOperator = stack.peek();
                    if (symbol.equals("+") || symbol.equals("-")) {
                        if (lastOperator.equals("(")) {
                            stack.push(symbol);
                        } else {
                            queue.offer(stack.pop());
                            stack.push(symbol);
                        }
                    } else if (symbol.equals("*") || symbol.equals("/")) {
                        if (lastOperator.equals("*") || lastOperator.equals("/")) {
                            queue.offer(stack.pop());
                            stack.push(symbol);
                        } else {
                            stack.push(symbol);
                        }
                    } else if (symbol.equals("(")) {
                        stack.push(symbol);
                        
                    } else if (symbol.equals(")")) {
                        while (!stack.peek().equals("(")) {
                            queue.offer(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
