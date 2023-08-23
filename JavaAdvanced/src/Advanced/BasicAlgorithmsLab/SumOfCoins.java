package Advanced.BasicAlgorithmsLab;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    private static boolean noAvailableCoins = false;
    private static int totalUsedCoins;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] availableCoins = Arrays
                .stream(scanner.nextLine().substring(7).split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> coinsMap = chooseCoins(availableCoins, targetSum);

        if (noAvailableCoins) {
            System.out.println("Error");
        } else {
            System.out.println("Number of coins to take: " + totalUsedCoins);
            coinsMap.forEach((key, value) ->
                    System.out.printf("%d coin(s) with value %d%n", value, key));
        }
    }

    private static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Arrays.sort(coins);
        List<Integer> sortedCoins = Arrays.stream(coins).boxed().collect(Collectors.toList());
        Collections.reverse(sortedCoins);

        Map<Integer, Integer> coinsMap = new LinkedHashMap<>();

        int i = 0;
        while (targetSum > 0) {
            if (i == sortedCoins.size()) {
                noAvailableCoins = true;
                break;
            }

            int currentCoin = sortedCoins.get(i);

            if (targetSum >= currentCoin) {
                int currentUsedCoinsCount = targetSum / currentCoin;
                targetSum = targetSum % currentCoin;
                coinsMap.put(currentCoin, currentUsedCoinsCount);
                totalUsedCoins += currentUsedCoinsCount;
            }

            i++;
        }

        return coinsMap;
    }
}
