package Advanced.GenericsEx.GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        int i = 1;
        while (i++ <= n) {
            Double input = Double.parseDouble(scanner.nextLine());
            box.add(input);
        }

        Double elementToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterElements(elementToCompare));
    }
}
