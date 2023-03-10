package Advanced.DefiningClassesEx.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> parentList = new ArrayList<>();
        List<Person> childrenList = new ArrayList<>();

        String personToPrint = scanner.nextLine();

        String info = scanner.nextLine();

        while (!info.equals("End")) {
            Pattern pattern1 = Pattern.compile("(?<parentFirstName>[A-Za-z]+) (?<parentLastName>[A-Za-z]+) - (?<childFirstName>[A-Za-z]+) (?<childSecondName>[A-Za-z]+)");
            Pattern pattern2 = Pattern.compile("(?<parentFirstName>[A-Za-z]+) (?<parentLastName>[A-Za-z]+) - (?<childDate>[0-9]+/[0-9]+/[0-9]+)");
            Pattern pattern3 = Pattern.compile("(?<parentDate>[0-9]+/[0-9]+/[0-9]+) - (?<childFirstName>[A-Za-z]+) (?<childLastName>[A-Za-z]+)");
            Pattern pattern4 = Pattern.compile("(?<parentDate>[0-9]+/[0-9]+/[0-9]+) - (?<childDate>[0-9]+/[0-9]+/[0-9]+)");
            Pattern pattern5 = Pattern.compile("(?<parentFirstName>[A-Za-z]+) (?<parentLastName>[A-Za-z]+) (?<childDate>[0-9]+/[0-9]+/[0-9]+)");

            Matcher matcher1 = pattern1.matcher(info);
            Matcher matcher2 = pattern2.matcher(info);
            Matcher matcher3 = pattern3.matcher(info);
            Matcher matcher4 = pattern4.matcher(info);
            Matcher matcher5 = pattern5.matcher(info);

            Person child;
            Person parent;
            if (matcher1.find()) {
                String parentFirstName = matcher1.group("parentFirstName");
                String parentLastName = matcher1.group("parentLastName");
                String childFirstName = matcher1.group("childFirstName");
                String childLastName = matcher1.group("childSecondName");

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

            } else if (matcher2.find()) {
                String parentFirstName = matcher2.group("parentFirstName");
                String parentLastName = matcher2.group("parentLastName");
                String childDate = matcher2.group("childDate");

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

            } else if (matcher3.find()) {
                String parentDate = matcher3.group("parentDate");
                String childFirstName = matcher3.group("childFirstName");
                String childLastName = matcher3.group("childLastName");

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

            } else if (matcher4.find()) {
                String parentDate = matcher4.group("parentDate");
                String childDate = matcher4.group("childDate");

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

            } else if (matcher5.find()) {
                String firstName = matcher5.group("parentFirstName");
                String lastName = matcher5.group("parentLastName");
                String date = matcher5.group("childDate");

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

        Pattern personDate = Pattern.compile("[0-9]+/[0-9]+/[0-9]+");
        Matcher matcher = personDate.matcher(personToPrint);

        Person person;
        if (matcher.find()) {
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
