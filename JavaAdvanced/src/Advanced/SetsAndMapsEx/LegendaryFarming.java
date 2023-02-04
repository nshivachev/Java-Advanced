package Advanced.SetsAndMapsEx;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryItemMap = new TreeMap<>();
        Map<String, Integer> junkItemMap = new TreeMap<>();

        legendaryItemMap.put("shards", 0);
        legendaryItemMap.put("fragments", 0);
        legendaryItemMap.put("motes", 0);

        String legendaryItem = "";

        boolean isLegendaryItemObtained = false;

        while (!isLegendaryItemObtained) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    legendaryItemMap.put(material, legendaryItemMap.get(material) + quantity);
                    if (legendaryItemMap.get(material) >= 250) {
                        legendaryItemMap.put(material, legendaryItemMap.get(material) - 250);

                        switch (material) {
                            case "shards":
                                legendaryItem = "Shadowmourne";
                                break;
                            case "fragments":
                                legendaryItem = "Valanyr";
                                break;
                            case "motes":
                                legendaryItem = "Dragonwrath";
                                break;
                        }

                        isLegendaryItemObtained = true;
                        break;
                    }
                } else {
                    junkItemMap.putIfAbsent(material, 0);
                    junkItemMap.put(material, junkItemMap.get(material) + quantity);
                }
            }
        }

        System.out.println(legendaryItem + " obtained!");
        legendaryItemMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
        junkItemMap.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
