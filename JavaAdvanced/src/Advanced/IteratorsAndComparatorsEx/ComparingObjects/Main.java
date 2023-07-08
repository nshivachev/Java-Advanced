package Advanced.IteratorsAndComparatorsEx.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String personInfo = scanner.nextLine();
        while (!personInfo.equals("END")) {
            String[] tokens = personInfo.split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            people.add(new Person(name, age, town));

            personInfo = scanner.nextLine();
        }

        Person personToCompare = people.get(Integer.parseInt(scanner.nextLine()) - 1);

        int samePeople = 0;
        int differentPeople = 0;
        int totalPeople = people.size();

        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }

        if (samePeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", samePeople, differentPeople, totalPeople);
        }
    }
}
