package Advanced.DefiningClassesEx.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Person {
    private String firstName;
    private String lastName;
    private String date;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        parents = new ArrayList<>();
        children = new ArrayList<>();
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addParent(String firstName, String lastName) {
        Predicate<Parent> predicate = p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName);
        if (getParents().stream().anyMatch(predicate)) {
            Parent parent = getParents().stream().filter(predicate).findFirst().get();
            parent.setFirstName(firstName);
            parent.setLastName(lastName);
        } else {
            getParents().add(new Parent(firstName, lastName));
        }
    }

    public void addParent(String date) {
        Predicate<Parent> predicate = p -> p.getDate().equals(date);
        if (getParents().stream().anyMatch(predicate)) {
            Parent parent = getParents().stream().filter(predicate).findFirst().get();
            parent.setDate(date);
        } else {
            getParents().add(new Parent(date));
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(String firstName, String lastName) {
        Predicate<Child> predicate = p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName);
        if (getChildren().stream().anyMatch(predicate)) {
            Child child =  getChildren().stream().filter(predicate).findFirst().get();
            child.setFirstName(firstName);
            child.setLastName(lastName);
        } else {
            getChildren().add(new Child(firstName, lastName));
        }
    }

    public void addChild(String date) {
        Predicate<Child> predicate = p -> p.getDate().equals(date);
        if (getChildren().stream().anyMatch(predicate)) {
            Child child =  getChildren().stream().filter(predicate).findFirst().get();
            child.setDate(date);
        } else {
            getChildren().add(new Child(date));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getFirstName(), getLastName(), getDate());
    }
}
