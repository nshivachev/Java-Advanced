package Advanced.SetsAndMapsLab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> productMap = new TreeMap<>();
        TreeMap<String, List<Double>> priceMap = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Revision")) {
            String[] tokens = command.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            productMap.putIfAbsent(shop, new ArrayList<>());
            productMap.get(shop).add(product);

            priceMap.putIfAbsent(shop, new ArrayList<>());
            priceMap.get(shop).add(price);

            command = scanner.nextLine();
        }

        for (var entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getValue().get(i), priceMap.get(entry.getKey()).get(i));
            }
        }
    }
}
