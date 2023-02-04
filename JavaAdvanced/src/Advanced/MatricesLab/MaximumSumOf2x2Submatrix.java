package Advanced.MatricesLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
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

        int maxSum = Integer.MIN_VALUE;

        int[][] outputMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    outputMatrix = new int[][]{
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }

        for (int[] arr : outputMatrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }
}