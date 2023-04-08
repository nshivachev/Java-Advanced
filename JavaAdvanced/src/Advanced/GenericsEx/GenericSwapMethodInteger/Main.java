package Advanced.GenericsEx.GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        int i = 1;
        while (i++ <= n) {
            box.add(Integer.parseInt(scanner.nextLine()));
        }

        int[] intArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        box.swap(intArr[0], intArr[1]);

        System.out.println(box);
    }
}
