package Advanced.IteratorsAndComparatorsEx.EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person other = (Person) o;
        return name.equals(other.name) && age == other.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person other) {
        int result = name.compareTo(other.name);
        return result == 0 ? Integer.compare(age, other.age) : result;
    }
}
