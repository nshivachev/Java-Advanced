package Advanced.MatricesEx;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();

        int rows = Integer.parseInt(size.split("\\s+")[0]);
        int cols = Integer.parseInt(size.split("\\s+")[1]);

        char matrix[][] = new char[rows][cols];

        String command = scanner.nextLine();

        int playerRow = 0;
        int playerCol = 0;

        int row = 0;
        while (!command.contains("R") && !command.contains("L") && !command.contains("U") && !command.contains("D")) {
            for (int i = 0; i < cols; i++) {
                matrix[row][i] = command.charAt(i);

                if (command.charAt(i) == 'P') {
                    playerRow = row;
                    playerCol = i;
                }
            }
            row++;

            command = scanner.nextLine();
        }

        boolean bunnyWins = false;
        boolean playerWins = false;

        for (int i = 0; i < command.length(); i++) {
            if (bunnyWins || playerWins) {
                break;
            }

            //move player
            char direction = command.charAt(i);
            if (direction == 'R') {
                if (isValid(playerRow, playerCol + 1, matrix)) {
                    if (matrix[playerRow][playerCol + 1] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow][playerCol + 1] = 'P';
                    } else {
                        bunnyWins = true;
                    }
                    playerCol++;
                } else {
                    matrix[playerRow][playerCol] = '.';
                    playerWins = true;
                }
            } else if (direction == 'L') {
                if (isValid(playerRow, playerCol - 1, matrix)) {
                    if (matrix[playerRow][playerCol - 1] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow][playerCol - 1] = 'P';
                    } else {
                        bunnyWins = true;
                    }
                    playerCol--;
                } else {
                    matrix[playerRow][playerCol] = '.';
                    playerWins = true;
                }
            } else if (direction == 'U') {
                if (isValid(playerRow - 1, playerCol, matrix)) {
                    if (matrix[playerRow - 1][playerCol] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow - 1][playerCol] = 'P';
                    } else {
                        bunnyWins = true;
                    }
                    playerRow--;
                } else {
                    matrix[playerRow][playerCol] = '.';
                    playerWins = true;
                }
            } else if (direction == 'D') {
                if (isValid(playerRow + 1, playerCol, matrix)) {
                    if (matrix[playerRow + 1][playerCol] != 'B') {
                        matrix[playerRow][playerCol] = '.';
                        matrix[playerRow + 1][playerCol] = 'P';
                    } else {
                        bunnyWins = true;
                    }
                    playerRow++;
                } else {
                    matrix[playerRow][playerCol] = '.';
                    playerWins = true;
                }
            }

            //Save bunnies to multiply
            ArrayDeque<Integer> bunniesQueue = new ArrayDeque<>();
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] == 'B') {
                        bunniesQueue.offer(r);
                        bunniesQueue.offer(c);
                    }
                }
            }

            //Multiply binnies
            while (!bunniesQueue.isEmpty()) {
                int r = bunniesQueue.poll();
                int c = bunniesQueue.poll();

                if (isValid(r + 1, c, matrix) && matrix[r + 1][c] != 'B') {
                    if (matrix[r + 1][c] == 'P') {
                        matrix[r + 1][c] = 'B';
                        bunnyWins = true;
                    } else {
                        matrix[r + 1][c] = 'B';
                    }
                }
                if (isValid(r - 1, c, matrix) && matrix[r - 1][c] != 'B') {
                    if (matrix[r - 1][c] == 'P') {
                        matrix[r - 1][c] = 'B';
                        bunnyWins = true;
                    } else {
                        matrix[r - 1][c] = 'B';
                    }
                }
                if (isValid(r, c + 1, matrix) && matrix[r][c + 1] != 'B') {
                    if (matrix[r][c + 1] == 'P') {
                        matrix[r][c + 1] = 'B';
                        bunnyWins = true;
                    } else {
                        matrix[r][c + 1] = 'B';
                    }
                }
                if (isValid(r, c - 1, matrix) && matrix[r][c - 1] != 'B') {
                    if (matrix[r][c - 1] == 'P') {
                        matrix[r][c - 1] = 'B';
                        bunnyWins = true;
                    } else {
                        matrix[r][c - 1] = 'B';
                    }
                }
            }
        }

        for (char[] arr : matrix) {
            for (char e : arr) {
                System.out.print(e);
            }
            System.out.println();
        }

        if (bunnyWins) {
            System.out.printf("dead: %d %d", playerRow, playerCol);
        } else if (playerWins) {
            System.out.printf("won: %d %d", playerRow, playerCol);
        }
    }
    public static boolean isValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}