package Advanced.SetsAndMapsEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementsSet = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            elementsSet.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        System.out.println(String.join(" ", elementsSet));
    }
}
