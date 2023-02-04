package Advanced.SetsAndMapsEx;

import java.util.*;
import java.util.stream.Stream;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> countryMap = new LinkedHashMap<>();

        String data = scanner.nextLine();
        while (!data.equals("report")) {
            String[] tokens = data.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            countryMap.putIfAbsent(country, new LinkedHashMap<>());
            countryMap.get(country).put(city, population);

            data = scanner.nextLine();
        }


        Map<String, Long> countryToPopulation = new LinkedHashMap<>();
        for (var entry : countryMap.entrySet()) {
            long sum = 0;
            for (var e : entry.getValue().entrySet()) {
                sum += e.getValue();
            }
            countryToPopulation.put(entry.getKey(), sum);
        }

//        List<Map.Entry<String, Integer>> countryList = new ArrayList<>(countryToPopulation.entrySet());
//        countryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//        countryList.forEach(x -> {
//            System.out.printf("%s (total population: %d)%n", x.getKey(), x.getValue());
//            List<Map.Entry<String, Integer>> cityList = new ArrayList<>(countryMap.get(x.getKey()).entrySet());
//            cityList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//            cityList.forEach(y -> System.out.printf("=>%s: %d%n", y.getKey(), y.getValue()));
//        });

        countryToPopulation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());
                    countryMap.get(entry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(e -> System.out.printf("=>%s: %d%n", e.getKey(), e.getValue()));
                });

    }
}
