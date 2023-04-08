package Advanced.GenericsEx.CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    customList.contains(tokens[1]);
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterValuesThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    customList.printValues();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
