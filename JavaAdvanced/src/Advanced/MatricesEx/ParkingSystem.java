package Advanced.MatricesEx;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();;

        int rows = Integer.parseInt(size.split("\\s+")[0]);
        int cols = Integer.parseInt(size.split("\\s+")[1]);

        boolean[][] parking = new boolean[rows][cols];

        String command = scanner.nextLine();

        while (!command.equals("stop")) {
            String[] tokens = command.split("\\s+");

            int entryRow = Integer.parseInt(tokens[0]);
            int spotRow = Integer.parseInt(tokens[1]);
            int spotCol = Integer.parseInt(tokens[2]);

            int finalSpotColumn = 0;
            boolean isParkSpotFound = false;

            for (int i = 0; i < cols - 1; i++) {
                if (isValidValue(spotRow, spotCol - i, parking) && !isParkingSpotFull(spotRow, spotCol - i, parking)) {
                    parking[spotRow][spotCol - i] = true;
                    isParkSpotFound = true;
                    finalSpotColumn = spotCol - i;
                    break;
                } else if (isValidValue(spotRow, spotCol + i, parking) && !isParkingSpotFull(spotRow, spotCol + i, parking)) {
                    parking[spotRow][spotCol + i] = true;
                    isParkSpotFound = true;
                    finalSpotColumn = spotCol + i;
                    break;
                }
            }

            if (isParkSpotFound) {
                System.out.println(finalSpotColumn + Math.abs(spotRow - entryRow) + 1);
            } else {
                System.out.printf("Row %d full%n", spotRow);
            }

            command = scanner.nextLine();
        }
    }
    public static boolean isParkingSpotFull(int row, int col, boolean[][]parking) {
        return parking[row][col];
    }

    public static boolean isValidValue(int row, int col, boolean[][]parking) {
        return row >= 0 && row < parking.length && col >= 1 && col < parking[row].length;
    }
}
