package Advanced.DefiningClassesEx.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String date;
    private List<Person> parents;
    private List<Person> children;

    public Person(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    public Person(String date) {
        this("", "", date);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDate() {
        return date;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getFirstName(), getLastName(), getDate());
    }
}
