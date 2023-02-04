package Advanced.StacksQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (char symbol : input.toCharArray()) {
            if (symbol == '{' || symbol == '[' || symbol == '(') {
                stack.push(symbol);
            } else if (stack.isEmpty()) {
                isBalanced = false;
                break;
            } else if (symbol == '}' && stack.pop() != '{') {
                isBalanced = false;
                break;
            } else if (symbol == ']' && stack.pop() != '[') {
                isBalanced = false;
                break;
            } else if (symbol == ')' && stack.pop() != '(') {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
