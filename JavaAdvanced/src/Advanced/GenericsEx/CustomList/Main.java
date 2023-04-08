package Advanced.GenericsEx.CustomList;

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
                    customList.printGreaterValuesCount(tokens[1]);
                    break;
                case "Max":
                    customList.printMaxValue();
                    break;
                case "Min":
                    customList.printMinValue();
                    break;
                case "Print":
                    customList.printValues();
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
