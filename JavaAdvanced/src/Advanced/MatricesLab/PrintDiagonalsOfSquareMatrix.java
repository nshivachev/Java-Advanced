package Advanced.MatricesLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();

        for (int[] arr : matrix) {

        }

        for (int row = 0; row < matrix.length; row++) {
            firstDiagonal.add(matrix[row][row]);
        }

        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            secondDiagonal.add(matrix[row][col++]);
        }

        for (int n : firstDiagonal) {
            System.out.print(n + " ");
        }

        System.out.println();

        for (int n : secondDiagonal) {
            System.out.print(n + " ");
        }
    }
}
