package Advanced.DefiningClassesEx.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        List<Department> departmentList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;

            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("\\d+")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            employeeList.add(employee);

            if (departmentList.stream().filter(d -> d.getName().equals(department)).collect(Collectors.toList()).isEmpty()) {
                departmentList.add(new Department(department));
            }
            departmentList.stream().filter(d -> d.getName().equals(department)).findFirst().get().getEmployeeList().add(employee);
        }

        Department highestPaiedDepartment = departmentList.stream()
                        .max(Comparator.comparing(Department::calculateAverageSalary)).get();

        System.out.println("Highest Average Salary: " + highestPaiedDepartment.getName());

        highestPaiedDepartment.getEmployeeList().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
