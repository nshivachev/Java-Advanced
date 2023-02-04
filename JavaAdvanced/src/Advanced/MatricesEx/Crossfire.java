package Advanced.MatricesEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        int n = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(n++);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+");

            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            /*for (int i = 0; i < matrix.size(); i++ ) {
                if (matrix.get(i).isEmpty()) {
                    matrix.remove(i);
                }
            }*/

            command = scanner.nextLine();
        }

        for (List<Integer> list : matrix) {
            for (int e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
