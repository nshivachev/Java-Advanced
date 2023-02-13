package Advanced.DefiningClassesEx.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> parentList = new ArrayList<>();
        List<Person> childrenList = new ArrayList<>();

        String personToPrint = scanner.nextLine();

        String info = scanner.nextLine();

        while (!info.equals("End")) {
            String[] tokens;

            Person child;
            Person parent;
            if (info.contains("-")) {
                tokens = info.split(" - ");

                String[] firstPart = tokens[0].split("\\s+");
                String[] secondPart = tokens[1].split("\\s+");

                if (firstPart.length == 2 && secondPart.length == 2) {
                    String parentFirstName = firstPart[0];
                    String parentLastName = firstPart[1];
                    String childFirstName = secondPart[0];
                    String childLastName = secondPart[1];

                    parent = getPerson(parentList, parentFirstName, parentLastName);
                    child = getPerson(childrenList, childFirstName, childLastName);

                    if (parent == null) {
                        parent = new Parent(parentFirstName, parentLastName);
                        parentList.add(parent);
                    } else {
                        parent.setFirstName(parentFirstName);
                        parent.setLastName(parentLastName);
                    }

                    if (child == null) {
                        child = new Child(childFirstName, childLastName);
                        childrenList.add(child);
                    } else {
                        child.setFirstName(childFirstName);
                        child.setLastName(childFirstName);
                    }

                    child.addParent(parentFirstName, parentLastName);
                    parent.addChild(childFirstName, childLastName);

                } else if (firstPart.length == 2 && secondPart.length == 1) {
                    String parentFirstName = firstPart[0];
                    String parentLastName = firstPart[1];
                    String childDate = secondPart[0];

                    parent = getPerson(parentList, parentFirstName, parentLastName);
                    child = getPerson(childrenList, childDate);

                    if (parent == null) {
                        parent = new Parent(parentFirstName, parentLastName);
                        parentList.add(parent);
                    } else {
                        parent.setFirstName(parentFirstName);
                        parent.setLastName(parentLastName);
                    }

                    if (child == null) {
                        child = new Child(childDate);
                        childrenList.add(child);
                    } else {
                        child.setDate(childDate);
                    }

                    child.addParent(parentFirstName, parentLastName);
                    parent.addChild(childDate);

                } else if (firstPart.length == 1 && secondPart.length == 2) {
                    String parentDate = firstPart[0];
                    String childFirstName = secondPart[0];
                    String childLastName = secondPart[1];

                    parent = getPerson(parentList, parentDate);
                    child = getPerson(childrenList, childFirstName, childLastName);

                    if (parent == null) {
                        parent = new Parent(parentDate);
                        parentList.add(new Person(parentDate));
                    } else {
                        parent.setDate(parentDate);
                    }

                    if (child == null) {
                        child = new Child(childFirstName, childLastName);
                        childrenList.add(child);
                    } else {
                        child.setFirstName(childFirstName);
                        child.setLastName(childLastName);
                    }

                    child.addParent(parentDate);
                    parent.addChild(childFirstName, childLastName);

                } else if (firstPart.length == 1 && secondPart.length == 1) {
                    String parentDate = firstPart[0];
                    String childDate = secondPart[0];

                    parent = getPerson(parentList, parentDate);
                    child = getPerson(childrenList, childDate);

                    if (parent == null) {
                        parent = new Parent(parentDate);
                        parentList.add(parent);
                    } else {
                        parent.setDate(parentDate);
                    }

                    if (child == null) {
                        child = new Child(childDate);
                        childrenList.add(child);
                    } else {
                        child.setDate(childDate);
                    }

                    child.addParent(parentDate);
                    parent.addChild(childDate);
                }
            } else {
                tokens = info.split("\\s+");

                String firstName = tokens[0];
                String lastName = tokens[1];
                String date = tokens[2];

                parent = getPerson(parentList, firstName, lastName, date);
                child = getPerson(childrenList, firstName, lastName, date);

                if (parent == null) {
                    parent = new Parent(firstName, lastName, date);
                    parentList.add(parent);
                } else {
                    parent.setFirstName(firstName);
                    parent.setLastName(lastName);
                    parent.setDate(date);
                }

                if (child == null) {
                    child = new Child(firstName, lastName, date);
                    childrenList.add(child);
                } else {
                    child.setFirstName(firstName);
                    child.setLastName(lastName);
                    child.setDate(date);
                }
            }

            info = scanner.nextLine();
        }

        Person person;
        if (personToPrint.contains("/")) {
            person = getPerson(parentList, personToPrint);

            System.out.println(person);
            System.out.println("Parents:");

            person = getPerson(childrenList, personToPrint);

            if (person.getParents() != null) {
                person.getParents().forEach(parent ->
                        System.out.println(getPerson(parentList, parent.getFirstName(), parent.getLastName(), parent.getDate())));
            }

            System.out.println("Children:");

            person = getPerson(parentList, personToPrint);

            if (person.getChildren() != null) {
                person.getChildren().forEach(child ->
                        System.out.println(getPerson(childrenList, child.getFirstName(), child.getLastName(), child.getDate())));
            }
        } else {
            String firstName = personToPrint.split("\\s+")[0];
            String lastName = personToPrint.split("\\s+")[1];

            person = getPerson(parentList, firstName, lastName);

            System.out.println(person);
            System.out.println("Parents:");

            person = getPerson(childrenList, firstName, lastName);

            if (person.getParents() != null) {
                person.getParents().forEach(parent ->
                        System.out.println(getPerson(parentList, parent.getFirstName(), parent.getLastName(), parent.getDate())));
            }
            System.out.println("Children:");

            person = getPerson(parentList, firstName, lastName);

            if (person.getChildren() != null) {
                person.getChildren().forEach(child ->
                        System.out.println(getPerson(childrenList, child.getFirstName(), child.getLastName(), child.getDate())));
            }
        }

    }

    public static Person getPerson(List<Person> persons, String firstName, String lastName) {
        Predicate<Person> personPredicate = p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName);
        if (persons.stream().anyMatch(personPredicate)) {
            return persons.stream().filter(personPredicate).findFirst().get();
        }
        return null;
    }

    public static Person getPerson(List<Person> persons, String date) {
        Predicate<Person> personPredicate = p -> p.getDate().equals(date);
        if (persons.stream().anyMatch(personPredicate)) {
            return persons.stream().filter(personPredicate).findFirst().get();
        }
        return null;
    }

    public static Person getPerson(List<Person> persons, String firstName, String lastName, String date) {
        Predicate<Person> personPredicate = p -> (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) || p.getDate().equals(date);
        if (persons.stream().anyMatch(personPredicate)) {
            return persons.stream().filter(personPredicate).findFirst().get();
        }
        return null;
    }
}
