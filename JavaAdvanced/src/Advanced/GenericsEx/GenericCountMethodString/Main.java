package Advanced.GenericsEx.GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        int i = 1;
        while (i++ <= n) {
            String input = scanner.nextLine();
            box.add(input);
        }

        String elementToCompare = scanner.nextLine();
        System.out.println(box.countGreaterElements(elementToCompare));
    }
}
