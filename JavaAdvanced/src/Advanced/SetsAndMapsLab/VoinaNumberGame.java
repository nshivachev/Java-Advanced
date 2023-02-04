package Advanced.SetsAndMapsLab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        Set<Integer> secondPlayerDeck = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 1;
        while (!firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty() && rounds++ <= 50) {
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            int secondPlayerCard = secondPlayerDeck.iterator().next();

            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if (firstPlayerDeck.size() == secondPlayerDeck.size()) {
            System.out.println("Draw!");
        }
    }
}
