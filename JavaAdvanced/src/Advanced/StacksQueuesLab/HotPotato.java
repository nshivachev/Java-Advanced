package Advanced.StacksQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque queue = new ArrayDeque<>();
        Arrays.stream(kids).forEach(queue::offer);

        int i = 1;
        while (queue.size() > 1) {
            if (i == n) {
                System.out.println("Removed " + queue.poll());
                i = 1;
                continue;
            }
            queue.offer(queue.poll());
            i++;
        }
        System.out.println("Last is " + queue.peek());
    }
}
