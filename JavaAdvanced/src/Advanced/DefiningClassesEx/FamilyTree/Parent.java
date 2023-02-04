package Advanced.DefiningClassesEx.FamilyTree;

import java.util.List;

public class Parent {
    private String firstName;
    private String lastName;
    private String date;
    private List<Parent> parents;
    private List<Child> children;

    public Parent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Parent(String date) {
        this.date = date;
    }
}
