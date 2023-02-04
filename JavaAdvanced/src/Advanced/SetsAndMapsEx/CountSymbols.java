package Advanced.SetsAndMapsEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> symbolsMap = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            symbolsMap.putIfAbsent(key, 0);
            symbolsMap.put(key, symbolsMap.get(key) + 1);
        }

        symbolsMap.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
