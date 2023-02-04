package Advanced.StacksQueuesEx;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "3a";
        try {
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("!!!!!!!!!!");
        }

        System.out.println("bbbbbbbbbbb");
    }
}
