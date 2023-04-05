package Advanced.DefiningClassesEx.FamilyTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new LinkedHashMap<>();

        String personToPrint = scanner.nextLine();

        String personInfo = scanner.nextLine();
        while (!personInfo.equals("End")) {
            Pattern nameNamePattern = Pattern.compile("(?<firstNameParent>[A-Za-z]+) (?<lastNameParent>[A-Za-z]+) - (?<firstNameChild>[A-Za-z]+) (?<lastNameChild>[A-Za-z]+)");
            Pattern nameDatePattern = Pattern.compile("(?<firstNameParent>[A-Za-z]+) (?<lastNameParent>[A-Za-z]+) - (?<dateChild>[\\d]+/[\\d]+/[\\d]{4})");
            Pattern dateNamePattern = Pattern.compile("(?<dateParent>[\\d]+/[\\d]+/[\\d]{4}) - (?<firstNameChild>[A-Za-z]+) (?<lastNameChild>[A-Za-z]+)");
            Pattern dateDatePattern = Pattern.compile("(?<dateParent>[\\d]+/[\\d]+/[\\d]{4}) - (?<dateChild>[\\d]+/[\\d]+/[\\d]{4})");
            Pattern updatePattern = Pattern.compile("(?<firstNamePerson>[A-Za-z]+) (?<lastNamePerson>[A-Za-z]+) (?<datePerson>[\\d]+/[\\d]+/[\\d]{4})");

            Matcher nameNameMatcher = nameNamePattern.matcher(personInfo);
            Matcher nameDateMatcher = nameDatePattern.matcher(personInfo);
            Matcher dateNameMatcher = dateNamePattern.matcher(personInfo);
            Matcher dateDateMatcher = dateDatePattern.matcher(personInfo);
            Matcher updateMatcher = updatePattern.matcher(personInfo);

            if (nameNameMatcher.find()) {
                String firstNameParent = nameNameMatcher.group("firstNameParent");
                String lastNameParent = nameNameMatcher.group("lastNameParent");
                String firstNameChild = nameNameMatcher.group("firstNameChild");
                String lastNameChild = nameNameMatcher.group("lastNameChild");

                String parentName = firstNameParent + " " + lastNameParent;
                String childName = firstNameChild + " " + lastNameChild;

                personMap.putIfAbsent(parentName, new Person(firstNameParent, lastNameParent));
                personMap.get(parentName).addChild(new Person(firstNameChild, lastNameChild));

                personMap.putIfAbsent(childName, new Person(firstNameChild, lastNameChild));
                personMap.get(childName).addParent(new Person(firstNameParent, lastNameParent));
            } else if (nameDateMatcher.find()) {
                String firstNameParent = nameDateMatcher.group("firstNameParent");
                String lastNameParent = nameDateMatcher.group("lastNameParent");
                String dateChild = nameDateMatcher.group("dateChild");

                String nameParent = firstNameParent + " " + lastNameParent;

                personMap.putIfAbsent(nameParent, new Person(firstNameParent, lastNameParent));
                personMap.get(nameParent).addChild(new Person(dateChild));

                personMap.putIfAbsent(dateChild, new Person(dateChild));
                personMap.get(dateChild).addParent(new Person(firstNameParent, lastNameParent));
            } else if (dateNameMatcher.find()) {
                String dateParent = dateNameMatcher.group("dateParent");
                String firstNameChild = dateNameMatcher.group("firstNameChild");
                String lastNameChild = dateNameMatcher.group("lastNameChild");

                String nameChild = firstNameChild + " " + lastNameChild;

                personMap.putIfAbsent(dateParent, new Person(dateParent));
                personMap.get(dateParent).addChild(new Person(firstNameChild, lastNameChild));

                personMap.putIfAbsent(nameChild, new Person(firstNameChild, lastNameChild));
                personMap.get(nameChild).addParent(new Person(dateParent));
            } else if (dateDateMatcher.find()) {
                String dateParent = dateDateMatcher.group("dateParent");
                String dateChild = dateDateMatcher.group("dateChild");

                personMap.putIfAbsent(dateParent, new Person(dateParent));
                personMap.get(dateParent).addChild(new Person(dateChild));

                personMap.putIfAbsent(dateChild, new Person(dateChild));
                personMap.get(dateChild).addParent(new Person(dateParent));
            } else if (updateMatcher.find()) {
                String firstNamePerson = updateMatcher.group("firstNamePerson");
                String lastNamePerson = updateMatcher.group("lastNamePerson");
                String datePerson = updateMatcher.group("datePerson");

                String namePerson = firstNamePerson + " " + lastNamePerson;

                personMap.forEach((key, value) -> {
                    if ((value.getFirstName().equals(firstNamePerson) && value.getLastName().equals(lastNamePerson)) || key.equals(datePerson)) {
                        value.setFirstName(firstNamePerson);
                        value.setLastName(lastNamePerson);
                        value.setDate(datePerson);
                    }

                    value.getChildren().forEach(child -> {
                        if ((child.getFirstName().equals(firstNamePerson) && child.getLastName().equals(lastNamePerson)) || child.getDate().equals(datePerson)) {
                            child.setFirstName(firstNamePerson);
                            child.setLastName(lastNamePerson);
                            child.setDate(datePerson);
                        }
                    });

                    value.getParents().forEach(parent -> {
                        if ((parent.getFirstName().equals(firstNamePerson) && parent.getLastName().equals(lastNamePerson)) || parent.getDate().equals(datePerson)) {
                            parent.setFirstName(firstNamePerson);
                            parent.setLastName(lastNamePerson);
                            parent.setDate(datePerson);
                        }
                    });
                });

                if (personToPrint.contains(namePerson) || personToPrint.contains(datePerson)) {
                    personToPrint = namePerson + " " + datePerson;
                }
            }
            personInfo = scanner.nextLine();
        }

        Pattern namePattern = Pattern.compile("(?<firstNameParent>[A-Za-z]+) (?<lastNameParent>[A-Za-z]+)");
        Pattern datePattern = Pattern.compile("(?<dateParent>[\\d]+/[\\d]+/[\\d]{4})");
        Pattern nameDatePattern = Pattern.compile("(?<firstNameParent>[A-Za-z]+) (?<lastNameParent>[A-Za-z]+) (?<dateParent>[\\d]+/[\\d]+/[\\d]{4})");

        Matcher nameMatcher = namePattern.matcher(personToPrint);
        Matcher dateMatcher = datePattern.matcher(personToPrint);
        Matcher nameDateMatcher = nameDatePattern.matcher(personToPrint);

        System.out.println(personToPrint);
        System.out.println("Parents:");

        if (nameMatcher.find()) {
            for (var entry : personMap.entrySet()) {
                if (entry.getValue().getFirstName().equals(nameMatcher.group("firstNameParent"))
                        && entry.getValue().getLastName().equals(nameMatcher.group("lastNameParent"))) {
                    entry.getValue().getParents().forEach(System.out::println);
                }
            }
        } else if (dateMatcher.find()) {
            for (var entry : personMap.entrySet()) {
                if (entry.getValue().getDate().equals(dateMatcher.group("dateParent"))) {
                    entry.getValue().getParents().forEach(System.out::println);
                }
            }
        } else if (nameDateMatcher.find()) {
            for (var entry : personMap.entrySet()) {
                if ((entry.getValue().getFirstName().equals(nameDateMatcher.group("firstNameParent"))
                        && entry.getValue().getLastName().equals(nameDateMatcher.group("lastNameParent")))
                        || entry.getValue().getDate().equals(nameDateMatcher.group("dateParent"))) {
                    entry.getValue().getParents().forEach(System.out::println);
                }
            }
        }

        System.out.println("Children:");

        if (nameMatcher.find()) {
            for (var entry : personMap.entrySet()) {
                if (entry.getValue().getFirstName().equals(nameMatcher.group("firstNameParent"))
                        && entry.getValue().getLastName().equals(nameMatcher.group("lastNameParent"))) {
                    entry.getValue().getChildren().forEach(System.out::println);
                }
            }
        } else if (dateMatcher.find()) {
            for (var entry : personMap.entrySet()) {
                if (entry.getValue().getDate().equals(dateMatcher.group("dateParent"))) {
                    entry.getValue().getChildren().forEach(System.out::println);
                }
            }
        } else if (nameDateMatcher.find()) {
            for (var entry : personMap.entrySet()) {
                if ((entry.getValue().getFirstName().equals(nameDateMatcher.group("firstNameParent"))
                        && entry.getValue().getLastName().equals(nameDateMatcher.group("lastNameParent")))
                        || entry.getValue().getDate().equals(nameDateMatcher.group("dateParent"))) {
                    entry.getValue().getChildren().forEach(System.out::println);
                }
            }
        }
    }
}
