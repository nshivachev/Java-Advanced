package Advanced.SetsAndMapsEx;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<singer>[A-Za-z\\s]+) @(?<venue>[A-Za-z\\s]+) (?<price>\\d+) (?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Integer>> venueToSingerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("price"));
                int ticketsCount = Integer.parseInt(matcher.group("count"));
                int totalPrice = ticketsPrice * ticketsCount;

                venueToSingerMap.putIfAbsent(venue, new LinkedHashMap<>());
                Map<String, Integer> singerToPriceMap = venueToSingerMap.get(venue);
                singerToPriceMap.putIfAbsent(singer, 0);
                singerToPriceMap.put(singer, singerToPriceMap.get(singer) + totalPrice);
            }

            input = scanner.nextLine();
        }

        venueToSingerMap.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        });
    }
}
