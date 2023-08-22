package Advanced.Exam_17_02_23.MouseInTheKitchen;

import java.util.Scanner;

public class MouseInTheKitchen {
    private static int row;
    private static int col;
    private static int cheeseCount = 0;
    private static int eatenCheese = 0;
    private static boolean isAllCheeseEaten = false;
    private static boolean isMouseTrapped = false;
    private static boolean isMouseInArea = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(",")[0]);
        int m = Integer.parseInt(input.split(",")[1]);

        char[][] area = new char[n][m];

        for (int r = 0; r < n; r++) {
            String rowData = scanner.nextLine();

            area[r] = rowData.toCharArray();

            if (rowData.contains("M")) {
                row = r;
                col = rowData.indexOf('M');
            }

            for (int c = 0; c < m; c++) {
                if (area[r][c] == 'C') {
                    cheeseCount++;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("danger") && !isAllCheeseEaten && !isMouseTrapped && isMouseInArea) {
            int rowMutator = 0;
            int colMutator = 0;

            switch (command) {
                case "up":
                    rowMutator = -1;
                    break;
                case "down":
                    rowMutator = 1;
                    break;
                case "right":
                    colMutator = 1;
                    break;
                case "left":
                    colMutator = -1;
                    break;
                default:
                    break;
            }

            moveMouse(area, rowMutator, colMutator);

            command = scanner.nextLine();
        }

        String result = null;

        if (isAllCheeseEaten) {
            result = "Happy mouse! All the cheese is eaten, good night!";
        } else if (isMouseTrapped) {
            result = "Mouse is trapped!";
        } else if (!isMouseInArea) {
            result = "No more cheese for tonight!";
        } else if (command.equals("danger")) {
            result = "Mouse will come back later!";
        }

        System.out.println(result);

        printArea(area);
    }

    private static void moveMouse(char[][] area, int rowMutator, int colMutator) {
        if (!isInBounds(area, row + rowMutator, col + colMutator)) {
            isMouseInArea = false;
            return;
        }

        if (area[row + rowMutator][col + colMutator] != '@') {
            area[row][col] = '*';

            row += rowMutator;
            col += colMutator;

            if (area[row][col] == 'C') {
                eatenCheese++;

                if (cheeseCount == eatenCheese) {
                    isAllCheeseEaten = true;
                }
            } else if (area[row][col] == 'T') {
                isMouseTrapped = true;
            }

            area[row][col] = 'M';
        }

    }

    private static boolean isInBounds(char[][] area, int r, int c) {
        return r >= 0 && r < area.length && c >= 0 && c < area[0].length;
    }

    private static void printArea(char[][] area) {
        for (char[] arr : area) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
