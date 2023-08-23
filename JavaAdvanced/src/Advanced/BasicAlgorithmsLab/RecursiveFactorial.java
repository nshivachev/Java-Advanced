package Advanced.BasicAlgorithmsLab;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(calculateFactorial(n));

    }

    private static long calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        } else if (number == 1) {
            return number;
        }


        return number * calculateFactorial(number - 1);
    }
}