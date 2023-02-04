package Advanced.DefiningClassesEx.FamilyTree;

import javax.sql.rowset.Predicate;
import java.util.ArrayList;
import java.util.List;

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
        this.firstName = firstName;
        this.lastName = lastName;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public Person(String date) {
        this.date = date;
        parents = new ArrayList<>();
        children = new ArrayList<>();
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

    public void setParents(Parent parents) {
        this.parents.add(parents);
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(Child children) {
        this.children.add(children);
    }
}
