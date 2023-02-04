package Advanced.MatricesLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int arr[] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<String> outputLines = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    outputLines.add(row + " " + col);
                }
            }
        }
        if (outputLines.isEmpty()) {
            System.out.println("not found");
        } else {
            for (String outputLine : outputLines) {
                System.out.println(outputLine);
            }
        }
    }
}
