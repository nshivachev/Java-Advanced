package Advanced.SetsAndMapsEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userToIpMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].substring(3);
            String user = tokens[2].substring(5);

            userToIpMap.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> ipToMessageMap = userToIpMap.get(user);
            ipToMessageMap.putIfAbsent(ip, 0);
            ipToMessageMap.put(ip, ipToMessageMap.get(ip) + 1);

            input = scanner.nextLine();
        }

        for (var entry : userToIpMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            StringBuilder sb = new StringBuilder();
                for (var e : entry.getValue().entrySet()) {
                    sb.append(String.format("%s => %d, ", e.getKey(), e.getValue()));
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";
            System.out.println(finalOutput);
        }
    }
}
