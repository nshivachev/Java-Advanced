package Advanced.MatricesLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] wrongValues = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongRow = wrongValues[0];
        int wrongCol = wrongValues[1];

        int wrongNumber = matrix[wrongRow][wrongCol];

        int[][] secondMatrix = new int[size][];

        for (int row = 0; row < matrix.length; row++) {
            secondMatrix[row] = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                secondMatrix[row][col] = matrix[row][col];
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    List<Integer> numbers = new ArrayList<>();

                    if (isInRange(row - 1, col, matrix, wrongNumber)) {
                        numbers.add(matrix[row - 1][col]);
                    }

                    if (isInRange(row + 1, col, matrix, wrongNumber)) {
                        numbers.add(matrix[row + 1][col]);
                    }

                    if (isInRange(row, col - 1, matrix, wrongNumber)) {
                        numbers.add(matrix[row][col - 1]);
                    }

                    if (isInRange(row, col + 1, matrix, wrongNumber)) {
                        numbers.add(matrix[row][col + 1]);
                    }

                    int sum = 0;
                    for (int n : numbers) {
                        sum += n;
                    }

                    secondMatrix[row][col] = sum;
                }
            }
        }

        for (int[] arr : secondMatrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    private static boolean isInRange(int row, int col, int[][] matrix, int wrongNumber) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length  && matrix[row][col] != wrongNumber;
    }
}
