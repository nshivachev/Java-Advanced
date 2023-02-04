package Advanced.StacksQueuesEx;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] robots = scanner.nextLine().split(";");

        int[] startingTimeArr = Arrays
                .stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentTimeSeconds = (startingTimeArr[0] * 3600) + (startingTimeArr[1] * 60) + startingTimeArr[2];

        int[] robotsNeededTime = new int[robots.length];
        int[] robotsEndTime = new int[robots.length];

        for (int i = 0; i < robots.length; i++) {
            int robotWorkingTime = Integer.parseInt(robots[i].split("-")[1]);
            robotsNeededTime[i] = robotWorkingTime;
            robotsEndTime[i] = currentTimeSeconds;
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

            for (int i = 0; i < robots.length; i++) {
                if (robotsEndTime[i] <= currentTimeSeconds) {
                    int finishWorkTime = currentTimeSeconds + robotsNeededTime[i];
                    robotsEndTime[i] = finishWorkTime;
                    String currentProduct = productQueue.poll();
                    int hours = (currentTimeSeconds / 3600) % 24;
                    int timeLeft = currentTimeSeconds % 3600;
                    int minutes = timeLeft / 60;
                    int seconds = timeLeft % 60;
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", robots[i].split("-")[0], currentProduct, hours, minutes, seconds);
                    isRobotFree = true;
                    break;

                }
            }

            if (!isRobotFree && productQueue.size() > 1) {
                String skippedProduct = productQueue.poll();
                productQueue.offer(skippedProduct);
            }
        }
    }
}
