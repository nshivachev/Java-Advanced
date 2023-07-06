package Advanced.IteratorsAndComparatorsEx.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");
            String commandName = tokens[0];
            switch (commandName) {
                case "Create":
                    if (tokens.length > 1) {
                        listyIterator = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String element : listyIterator) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }

    }
}
