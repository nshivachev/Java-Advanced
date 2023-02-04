package Advanced.SetsAndMapsLab;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> studentRecord = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String students = scanner.nextLine();
            String studentName = students.split("\\s+")[0];
            double grade = Double.parseDouble(students.split("\\s+")[1]);

            studentRecord.putIfAbsent(studentName, new ArrayList<>());
            studentRecord.get(studentName).add(grade);
        }

        for (var entrySet : studentRecord.entrySet()) {
            double gradeSum = 0;
            System.out.print(entrySet.getKey() + " -> ");
            for (double grade : entrySet.getValue()) {
                gradeSum += grade;
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)%n", gradeSum / studentRecord.get(entrySet.getKey()).size());
        }
    }
}
