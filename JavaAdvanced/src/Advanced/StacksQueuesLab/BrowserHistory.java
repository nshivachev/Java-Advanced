package Advanced.StacksQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String instruction = scanner.nextLine();
        String currentPage = "";

        while (!instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    instruction = scanner.nextLine();
                    continue;
                } else {
                    currentPage = browserHistory.pop();
                }
            } else {
                if (!currentPage.equals("")) {
                    browserHistory.push(currentPage);
                }
                currentPage = instruction;
            }
            System.out.println(currentPage);
            instruction = scanner.nextLine();
        }
    }
}
