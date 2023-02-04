package Advanced.MatricesLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int rowsCount = 0;
        int columnsCount = matrix[0].length;
        int elementsSum = 0;

        for (int[] arr : matrix) {
            for (int element : arr) {
                elementsSum += element;
            }
            rowsCount++;
        }

        System.out.println(rowsCount);
        System.out.println(columnsCount);
        System.out.println(elementsSum);
    }
}