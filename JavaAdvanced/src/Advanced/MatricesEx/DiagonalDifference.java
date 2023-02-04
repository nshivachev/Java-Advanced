package Advanced.MatricesEx;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int firstDiagSum = 0;
        for (int i = 0; i < size; i++) {
            firstDiagSum += matrix[i][i];
        }

        int secondDiagSum = 0;
        for (int row = 0, col = size - 1; row < size; row++, col--) {
            secondDiagSum += matrix[row][col];
        }

//        for (int i = 0; i < size; i++) {
//            secondDiagSum += matrix[i][size - 1 - i];
//        }

        System.out.println(Math.abs(firstDiagSum - secondDiagSum));
    }
}
