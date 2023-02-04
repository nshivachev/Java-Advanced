package Advanced.MatricesEx;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        int n = 1;

        if (pattern.equals("A")) {
            for (int col = 0 ; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = n;
                    n++;
                }
            }
        } else if (pattern.equals("B")) {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = n;
                        n++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = n;
                        n++;
                    }
                }
            }
        }

        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
