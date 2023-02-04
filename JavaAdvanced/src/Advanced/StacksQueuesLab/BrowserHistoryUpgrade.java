package Advanced.StacksQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String instruction = scanner.nextLine();
        String currentPage = null;

        while (!instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    instruction = scanner.nextLine();
                    continue;
                } else {
                    forward.push(currentPage);
                    currentPage = browserHistory.pop();
                }
            } else if (instruction.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    instruction = scanner.nextLine();
                    continue;
                } else {
                    browserHistory.push(currentPage);
                    currentPage = forward.pop();
                }
            } else {
                if (currentPage != null) {
                    browserHistory.push(currentPage);
                    forward.clear();
                }
                currentPage = instruction;
            }
            System.out.println(currentPage);
            instruction = scanner.nextLine();
        }
    }
}
