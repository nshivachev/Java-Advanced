package Advanced.SetsAndMapsLab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, double[]> studentMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String student = scanner.nextLine();
            double[] grades = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentMap.put(student, grades);
        }

        studentMap.entrySet().forEach(entry -> {
            double sum = 0.0;
            for (double grade : entry.getValue()) {
                sum += grade;
            }
            System.out.println(entry.getKey() + " is graduated with " + sum / entry.getValue().length);
        });
    }
}
