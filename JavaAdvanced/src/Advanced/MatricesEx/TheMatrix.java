package Advanced.MatricesEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();

        int rows = Integer.parseInt(size.split("\\s+")[0]);
        int cols = Integer.parseInt(size.split("\\s+")[1]);

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }

        char fillChar = scanner.nextLine().charAt(0);

        String startingSymbol = scanner.nextLine();

        int startRow = Integer.parseInt(startingSymbol.split("\\s+")[0]);
        int startCol = Integer.parseInt(startingSymbol.split("\\s+")[1]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        char charToBeChanged = matrix[startRow][startCol];

        matrix[startRow][startCol] = fillChar;

        queue.offer(startRow);
        queue.offer(startCol);

        while (!queue.isEmpty()) {
            startRow = queue.poll();
            startCol = queue.poll();

            if (isValid(startRow - 1, startCol, matrix) && matrix[startRow - 1][startCol] == charToBeChanged) {
                matrix[startRow - 1][startCol] = fillChar;
                queue.offer(startRow - 1);
                queue.offer(startCol);
            }

            if (isValid(startRow + 1, startCol, matrix) && matrix[startRow + 1][startCol] == charToBeChanged) {
                matrix[startRow + 1][startCol] = fillChar;
                queue.offer(startRow + 1);
                queue.offer(startCol);
            }

            if (isValid(startRow, startCol - 1, matrix) && matrix[startRow][startCol - 1] == charToBeChanged) {
                matrix[startRow][startCol - 1] = fillChar;
                queue.offer(startRow);
                queue.offer(startCol - 1);
            }

            if (isValid(startRow, startCol + 1, matrix) && matrix[startRow][startCol + 1] == charToBeChanged) {
                matrix[startRow][startCol + 1] = fillChar;
                queue.offer(startRow);
                queue.offer(startCol + 1);
            }
        }

        for (char[] symbols : matrix) {
            for (char symbol : symbols) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    public static boolean isValid(int row, int col, char matrix[][]) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
