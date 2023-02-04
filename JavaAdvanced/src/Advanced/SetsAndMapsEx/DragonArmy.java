package Advanced.SetsAndMapsEx;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, int[]>> dragonsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            int damage;
            int health;
            int armor;

            if (input.contains("null")) {
                if (tokens[2].equals("null")) {
                    damage = 45;
                } else {
                    damage = Integer.parseInt(tokens[2]);
                }

                if (tokens[3].equals("null")) {
                    health = 250;
                } else {
                    health = Integer.parseInt(tokens[3]);
                }

                if (tokens[4].equals("null")) {
                    armor = 10;
                } else {
                    armor = Integer.parseInt(tokens[4]);
                }
            } else {
                damage = Integer.parseInt(tokens[2]);
                health = Integer.parseInt(tokens[3]);
                armor = Integer.parseInt(tokens[4]);
            }

            dragonsMap.putIfAbsent(type, new TreeMap<>());
            dragonsMap.get(type).putIfAbsent(name, new int[3]);
            dragonsMap.get(type).get(name)[0] = damage;
            dragonsMap.get(type).get(name)[1] = health;
            dragonsMap.get(type).get(name)[2] = armor;
        }

        Map<String, double[]> typeToStats = new LinkedHashMap<>();
        for (var entry : dragonsMap.entrySet()) {
            int d = 0;
            int h = 0;
            int a = 0;

            for (var e : entry.getValue().entrySet()) {
                d += e.getValue()[0];
                h += e.getValue()[1];
                a += e.getValue()[2];
            }

            typeToStats.putIfAbsent(entry.getKey(), new double[3]);
            typeToStats.get(entry.getKey())[0] = (double) d / entry.getValue().size();
            typeToStats.get(entry.getKey())[1] = (double) h / entry.getValue().size();
            typeToStats.get(entry.getKey())[2] = (double) a / entry.getValue().size();
        }

        typeToStats.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, value[0], value[1], value[2]);
            dragonsMap.get(key).forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]));
        });
    }
}
