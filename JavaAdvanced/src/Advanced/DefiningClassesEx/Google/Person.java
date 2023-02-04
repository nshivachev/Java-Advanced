package Advanced.DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parent> parentList;
    private List<Child> childList;

    public Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setCompany(String name, String department, double salary) {
        this.company = new Company(name, department, salary);
    }

    public void setCar(String model, String speed) {
        this.car = new Car(model, speed);
    }

    public void addPokemon(String name, String type) {
        this.pokemonList.add(new Pokemon(name, type));
    }

    public void addParent(String name, String birthday) {
        this.parentList.add(new Parent(name, birthday));
    }

    public void addChild(String name, String birthday) {
        this.childList.add(new Child(name, birthday));
    }

    public static class Company {
        String name;
        String department;
        double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", name, department, salary);
        }
    }

    public static class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s %s", name, type);
        }
    }

    public static class Parent {
        private String name;
        private String birthday;

        public Parent(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", name, birthday);
        }
    }

    public static class Child {
        private String name;
        private String birthday;

        public Child(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", name, birthday);
        }
    }

    public static class Car {
        String model;
        String speed;

        public Car(String model, String speed) {
            this.model = model;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return String.format("%s %s", model, speed);
        }
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
