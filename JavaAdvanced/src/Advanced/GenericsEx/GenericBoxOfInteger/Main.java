package Advanced.GenericsEx.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int i = 1;
        while (i++ <= n) {
            System.out.println(new Box<>(Integer.parseInt(scanner.nextLine())));
        }
    }
}
