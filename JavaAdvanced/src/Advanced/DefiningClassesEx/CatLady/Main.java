package Advanced.DefiningClassesEx.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catMap = new HashMap<>();

        String info = scanner.nextLine();

        while (!info.equals("End")) {
            String[] tokens = info.split("\\s+");

            String breed = tokens[0];
            String name = tokens[1];
            double size = Double.parseDouble(tokens[2]);

            Cat cat = null;
            if (breed.equals("Siamese")) {
                cat = new Siamese(name, size);
            } else if (breed.equals("Cymric")) {
                cat = new Cymric(name, size);
            } else if (breed.equals("StreetExtraordinaire")) {
                cat = new StreetExtraordinaire(name, size);
            }
            
            catMap.put(cat.getName(), cat);

            info = scanner.nextLine();
        }

        String catToPrint = scanner.nextLine();

        System.out.println(catMap.get(catToPrint));
    }
}
