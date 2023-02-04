package Advanced.DefiningClassesEx.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person>personMap = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            String personName = tokens[0];
            String infoType = tokens[1];
            String name = tokens[2];
            String property = tokens[3];

            personMap.putIfAbsent(personName, new Person(personName));

            Person person = personMap.get(personName);
            switch (infoType) {
                case "company":
                    double salary = Double.parseDouble(tokens[4]);
                    person.setCompany(name, property, salary);
                    break;
                case "pokemon":
                    person.addPokemon(name, property);
                    break;
                case "parents":
                    person.addParent(name, property);
                    break;
                case "children":
                    person.addChild(name, property);
                    break;
                case "car":
                    person.setCar(name, property);
                    break;
            }

            command = scanner.nextLine();
        }

        String personToPrint = scanner.nextLine();
        Person person = personMap.get(personToPrint);

        System.out.printf("%s%nCompany:%n", person);
        if (person.getCompany() != null) {
            System.out.println(person.getCompany());
        }
        System.out.println("Car:");
        if (person.getCar() != null) {
            System.out.println(person.getCar());
        }
        System.out.println("Pokemon:");
        if (!person.getPokemonList().isEmpty()) {
            person.getPokemonList().forEach(System.out::println);
        }
        System.out.println("Parents:");
        if (!person.getParentList().isEmpty()) {
            person.getParentList().forEach(System.out::println);
        }
        System.out.println("Children:");
        if (!person.getChildList().isEmpty()) {
            person.getChildList().forEach(System.out::println);
        }
    }
}
