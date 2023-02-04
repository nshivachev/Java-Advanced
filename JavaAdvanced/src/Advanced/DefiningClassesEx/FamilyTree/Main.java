package Advanced.DefiningClassesEx.FamilyTree;

import javax.sql.rowset.Predicate;
import java.util.*;
import Advanced.DefiningClassesEx.FamilyTree.Person;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String input = scanner.nextLine();

        String info = scanner.nextLine();

        while (!info.equals("End")) {
            String[] tokens;

            if (info.contains("-")) {
                tokens = info.split(" - ");

                String[] firstPart = tokens[0].split("\\s+");
                String[] secondPart = tokens[1].split("\\s+");

                Person personChild;
                Person personParent;
                if (firstPart.length == 2 && secondPart.length == 2) {
                    String parentFirstName = firstPart[0];
                    String parentLastName = firstPart[1];
                    String childFirstName = secondPart[0];
                    String childLastName = secondPart[1];

                    personParent = getPersonByName(persons, parentFirstName, parentLastName);
                    personChild = getPersonByName(persons, childFirstName, childLastName);

                    if (personParent == null) {
                        persons.add(new Person(parentFirstName, parentLastName));
                    }

                    if (personChild == null) {
                        persons.add(new Person(childFirstName, childLastName));
                    }

                    personParent.setChildren(new Child(childFirstName, childLastName));
                    personChild.setParents(new Parent(parentFirstName, parentLastName));

                } else if (firstPart.length == 2 && secondPart.length == 1) {
                    String parentFirstName = firstPart[0];
                    String parentLastName = firstPart[1];
                    String childDate = secondPart[0];

                    personParent = getPersonByName(persons, parentFirstName, parentLastName);
                    personChild = getPersonByDate(persons, childDate);

                    if (personParent == null) {
                        persons.add(new Person(parentFirstName, parentLastName));
                    }

                    if (personChild == null) {
                        persons.add(new Person(childDate));
                    }

                    personParent.setChildren(new Child(childDate));
                    personChild.setParents(new Parent(parentFirstName, parentLastName));

                } else if (firstPart.length == 1 && secondPart.length == 2) {
                    String parentDate = firstPart[0];
                    String childFirstName = secondPart[1];
                    String childLastName = secondPart[2];

                    personParent = getPersonByDate(persons, parentDate);
                    personChild = getPersonByName(persons, childFirstName, childLastName);

                    if (personParent == null) {
                        persons.add(new Person(parentDate));
                    }

                    if (personChild == null) {
                        persons.add(new Person(childFirstName, childLastName));
                    }

                    personParent.setChildren(new Child(childFirstName, childLastName));
                    personChild.setParents(new Parent(parentDate));

                } else if (firstPart.length == 1 && secondPart.length == 1) {
                    String parentDate = firstPart[0];
                    String childDate = secondPart[0];

                    personParent = getPersonByDate(persons, parentDate);
                    personChild = getPersonByDate(persons, childDate);

                    if (personParent == null) {
                        persons.add(new Person(parentDate));
                    }

                    if (personChild == null) {
                        persons.add(new Person(childDate));
                    }
                }
            } else {
                tokens = info.split("\\s+");

                String firstName = tokens[0];
                String lastName = tokens[1];
                String date = tokens[2];

                Person person = getPersonByNameAndDate(persons, firstName, lastName, date);
                if (person != null) {
                    persons.add(new Person(firstName, lastName, date));
                }
            }

            info = scanner.nextLine();
        }

        System.out.println();
    }

    public static Person getPersonByName(List<Person> persons, String firstName, String lastName) {
        if (persons.stream().anyMatch(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))) {
            return persons.stream().filter(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)).findFirst().get();
        }
        return null;
    }

    public static Person getPersonByDate(List<Person> persons, String date) {
        if (persons.stream().anyMatch(p -> p.getDate().equals(date))) {
            return persons.stream().filter(p -> p.getDate().equals(date)).findFirst().get();
        }
        return null;
    }

    public static Person getPersonByNameAndDate(List<Person> persons, String firstName, String lastName, String date) {
        if (persons.stream().anyMatch(p -> (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) || p.getDate().equals(date))) {
            return persons.stream()
                    .filter(p -> (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) || p.getDate().equals(date))
                    .findFirst()
                    .get();
        }
        return null;
    }
}
