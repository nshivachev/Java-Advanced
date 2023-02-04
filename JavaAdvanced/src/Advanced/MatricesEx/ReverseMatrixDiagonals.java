package Advanced.MatricesEx;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int row = rows - 1; row >= 0; row--) {
            if (row == rows - 1) {
                for (int col = cols - 1; col >= 0; col--) {
                    for (int c = col, r = rows - 1; c < cols && r >= 0; c++, r--) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println();
                }
            } else {
                for (int c = 0, r = row; c < cols && r >= 0; c++, r--) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}
