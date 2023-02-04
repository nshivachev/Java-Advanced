package Advanced.StacksQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> digits = new ArrayDeque<>();

        if (decimal == 0) {
            System.out.println(0);
        }

        while (decimal != 0) {
            digits.push(decimal % 2);
            decimal /= 2;
        }
        while (!digits.isEmpty()) {
            System.out.print(digits.pop());
        }
    }
}
