package Advanced.IteratorsAndComparatorsEx.LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        SmartArray smartArray = new SmartArray();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            String action = command.split("\\s+")[0];
            int number = Integer.parseInt(command.split("\\s+")[1]);

            if (action.equals("Add")) {
                smartArray.add(number);
            } else if (action.equals("Remove")) {
                smartArray.remove(number);
            }
        }

        System.out.println(smartArray.getSize());
        smartArray.forEach(element -> System.out.print(element + " "));
    }
}
