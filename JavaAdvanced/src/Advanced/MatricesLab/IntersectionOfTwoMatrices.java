package Advanced.MatricesLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols, scanner);

        char[][] output = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                char firstElement = firstMatrix[row][col];
                char secondElement = secondMatrix[row][col];
                char symbol = firstElement == secondElement ? firstElement : '*';
                output[row][col] = symbol;
            }
        }
        printMatrix(output);
    }
    public static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    public static void printMatrix(char matrix[][]) {
        for (char arr[] : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
