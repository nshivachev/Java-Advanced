package Advanced.IteratorsAndComparatorsEx.EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        HashSet<Person> hashSet = new HashSet<>();
        TreeSet<Person> treeSet = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");

            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);

            Person person = new Person(name, age);

            hashSet.add(person);
            treeSet.add(person);
        }

        System.out.println(hashSet.size());
        System.out.println(treeSet.size());
    }
}
