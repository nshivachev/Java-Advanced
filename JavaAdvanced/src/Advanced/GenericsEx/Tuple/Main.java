package Advanced.GenericsEx.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameAndAddress = scanner.nextLine().split("\\s+");
        String names = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];
        Tuple<String, String> firstTuple = new Tuple<>(names, address);
        System.out.println(firstTuple);

        String[] nameAndBeerAmount = scanner.nextLine().split("\\s+");
        String name = nameAndBeerAmount[0];
        int beerAmount = Integer.parseInt(nameAndBeerAmount[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, beerAmount);
        System.out.println(secondTuple);

        String[] intAndDouble = scanner.nextLine().split("\\s+");
        int intValue = Integer.parseInt(intAndDouble[0]);
        double doubleValue = Double.parseDouble(intAndDouble[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(intValue, doubleValue);
        System.out.println(thirdTuple);
    }
}
