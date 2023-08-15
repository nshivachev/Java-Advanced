package Advanced.ExamPreparationSecond.Bomb;

import java.util.Scanner;

public class Bomb {
    private static int row = 0;
    private static int col = 0;
    private static int deactivatedBombs = 0;
    private static int bombCount = 0;
    private static boolean endRout = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commandsArr = scanner.nextLine().split(",");

        char[][] field = new char[size][size];

        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int c = 0; c < size; c++) {
                field[r][c] = input[c].charAt(0);

                if (field[r][c] == 'B') {
                    bombCount++;
                } else if (field[r][c] == 's') {
                    row = r;
                    col = c;
                }
            }
        }

//        for (int r = 0; r < size; r++) {
//            field[r] = scanner.nextLine().replaceAll(" ", "").toCharArray();
//        }
//
//        for (int r = 0; r < size; r++) {
//            for (int c = 0; c < size; c++) {
//                if (field[r][c] == 's') {
//                    row = r;
//                    col = c;
//                } else if (field[r][c] == 'B') {
//                    bombCount++;
//                }
//            }
//        }

        for (String command : commandsArr) {
            switch (command) {
                case "left":
                    moveSapper(field, row, col - 1);
                    break;
                case "right":
                    moveSapper(field, row, col + 1);
                    break;
                case "up":
                    moveSapper(field, row - 1, col);
                    break;
                case "down":
                    moveSapper(field, row + 1, col);
                    break;
                default:
                    break;
            }

            if (endRout) {
                break;
            }
        }

        String result;

        if (deactivatedBombs == bombCount) {
            result = "Congratulations! You found all bombs!";
        } else if (endRout) {
            result = String.format("END! %d bombs left on the field", bombCount - deactivatedBombs);
        } else {
            result = String.format("%d bombs left on the field. Sapper position: (%d,%d)", bombCount - deactivatedBombs, row, col);
        }

        System.out.println(result);
    }

    private static void moveSapper(char field[][], int r, int c) {
        if (r >= 0 && r < field.length && c >= 0 && c < field.length) {
            row = r;
            col = c;
        }

        if (field[row][col] == 'B') {
            field[row][col] = '+';
            deactivatedBombs++;
            System.out.println( "You found a bomb!");
        }

        if (field[row][col] == 'e' || deactivatedBombs == bombCount) {
            endRout = true;
        }
    }
}
