package Advanced.SetsAndMapsEx;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> personToCardsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String personName = input.split(": ")[0];
            String[] cards = input.split(": ")[1].split(", ");

            personToCardsMap.putIfAbsent(personName, new HashSet<>());
            Collections.addAll(personToCardsMap.get(personName), cards);

            input = scanner.nextLine();
        }

        personToCardsMap.forEach((key, value) -> System.out.println(key + ": " + calculateCardsPower(value)));
    }
    public static int calculateCardsPower(Set<String> cardsSet) {
        int sum = 0;
        for (String card : cardsSet) {
            int cardPower;
            switch (card.substring(0, card.length() - 1)) {
                case "J":
                    cardPower = 11;
                    break;
                case "Q":
                    cardPower = 12;
                    break;
                case "K":
                    cardPower = 13;
                    break;
                case "A":
                    cardPower = 14;
                    break;
                default:
                    cardPower = Integer.parseInt(card.substring(0, card.length() - 1));
                    break;
            }

            int cardType;
            switch (card.substring(card.length() - 1)) {
                case "S":
                    cardType = 4;
                    break;
                case "H":
                    cardType = 3;
                    break;
                case "D":
                    cardType = 2;
                    break;
                case "C":
                    cardType = 1;
                    break;
                default:
                    cardType = 0;
                    break;
            }
            sum += cardPower * cardType;
        }
        return sum;
    }
}
