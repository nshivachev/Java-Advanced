package Advanced.SetsAndMapsLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentMap.get(continent).get(country).add(city);
        }

        continentMap.forEach((key, value) -> {
            System.out.println(key + ":");

            value.entrySet().forEach(e -> {
                System.out.println("  " + e.getKey() + " -> " + String.join(", ", e.getValue()));
            });
        });
    }
}
