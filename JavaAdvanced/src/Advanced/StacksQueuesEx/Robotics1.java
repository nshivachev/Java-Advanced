package Advanced.StacksQueuesEx;

import java.util.*;

public class Robotics1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] robots = scanner.nextLine().split(";");
        int[] startingTimeArr = Arrays
                .stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentTimeSeconds = (startingTimeArr[0] * 3600) + (startingTimeArr[1] * 60) + startingTimeArr[2];

        Map<String, Integer> robotsNeededTimeMap = new LinkedHashMap<>();
        Map<String, Integer> robotsEndTimeMap = new LinkedHashMap<>();
        for (String robot : robots) {
            String robotName = robot.split("-")[0];
            int robotWorkingTime = Integer.parseInt(robot.split("-")[1]);
            robotsNeededTimeMap.put(robotName, robotWorkingTime);
            robotsEndTimeMap.put(robotName, currentTimeSeconds);
        }

        String command = scanner.nextLine();
        ArrayDeque<String> productQueue = new ArrayDeque<>();
        while (!command.equals("End")) {
            productQueue.offer(command);
            command = scanner.nextLine();
        }

        while (!productQueue.isEmpty()) {
            currentTimeSeconds++;
            boolean isRobotFree = false;
            for (String robot : robots) {
                String robotName = robot.split("-")[0];
                if (robotsEndTimeMap.get(robotName) <= currentTimeSeconds) {
                    int finishWorkTime = currentTimeSeconds + robotsNeededTimeMap.get(robotName);
                    robotsEndTimeMap.put(robotName, finishWorkTime);
                    String currentProduct = productQueue.poll();
                    int hours = (currentTimeSeconds / 3600) % 24;
                    int timeLeft = currentTimeSeconds % 3600;
                    int minutes = timeLeft / 60;
                    int seconds = timeLeft % 60;
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotName, currentProduct, hours, minutes, seconds);
                    isRobotFree = true;
                    break;
                }
            }

            if (!isRobotFree && productQueue.size() > 1) {
                productQueue.offer(productQueue.poll());
            }
        }
    }
}
