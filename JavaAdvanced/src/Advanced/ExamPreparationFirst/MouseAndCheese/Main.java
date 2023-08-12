package Advanced.ExamPreparationFirst.MouseAndCheese;

import java.util.Scanner;

public class Main {
    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            field[i] = input.toCharArray();

            if (input.contains("M")) {
                row = i;
                col = input.indexOf("M");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    moveMouse(field, -1, 0);
                    break;
                case "down":
                    moveMouse(field, 1, 0);
                    break;
                case "left":
                    moveMouse(field, 0, -1);
                    break;
                case "right":
                    moveMouse(field, 0, 1);
                    break;
            }

            if (!mouseIsInField) {
                break;
            }

            command = scanner.nextLine();
        }

        if (!mouseIsInField) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        }

        printField(field);
    }

    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
        field[row][col] = '-';

        row += rowMutator;
        col += colMutator;

        if (!isInBounds(field, row, col)) {
            mouseIsInField = false;
            return;
        }

        if (field[row][col] == 'c') {
            eatenCheese++;
        } else if (field[row][col] == 'B') {
            moveMouse(field, rowMutator, colMutator);
        }

        field[row][col] = 'M';
    }

    private static boolean isInBounds(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field.length;
    }

    private static void printField(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
