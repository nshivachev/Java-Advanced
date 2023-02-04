package Advanced.SetsAndMapsEx;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Set<String>> userToIpMap = new TreeMap<>();
        Map<String, Integer> userToDurationMap = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String ipAddress = tokens[0];
            String userName = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            userToIpMap.putIfAbsent(userName, new TreeSet<>());
            userToIpMap.get(userName).add(ipAddress);

            userToDurationMap.putIfAbsent(userName, 0);
            userToDurationMap.put(userName, userToDurationMap.get(userName) + duration);
        }

        userToDurationMap.entrySet().forEach(entry -> {
            System.out.printf("%s: %d ", entry.getKey(), entry.getValue());
            System.out.println(userToIpMap.get(entry.getKey()));
        });
    }
}
