package Advanced.GenericsEx.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nameAndAddress = scanner.nextLine().split("\\s+");
        String names = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];
        String town = nameAndAddress[3];
        Tuple<String, String, String> firstTuple = new Tuple<>(names, address, town);
        System.out.println(firstTuple);

        String[] nameAndBeer = scanner.nextLine().split("\\s+");
        String name = nameAndBeer[0];
        int beerAmount = Integer.parseInt(nameAndBeer[1]);
        boolean isDrink = nameAndBeer[2].equals("drunk");
        Tuple<String, Integer, Boolean> secondTuple = new Tuple<>(name, beerAmount, isDrink);
        System.out.println(secondTuple);

        String[] nameAndBank = scanner.nextLine().split("\\s+");
        name = nameAndBank[0];
        double bankAcc = Double.parseDouble(nameAndBank[1]);
        String bankName = nameAndBank[2];
        Tuple<String, Double, String> thirdTuple = new Tuple<>(name, bankAcc, bankName);
        System.out.println(thirdTuple);
    }
}
