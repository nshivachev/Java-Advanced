package Advanced.DefiningClassesEx.FamilyTree;

import java.util.List;

public class Child {
    private String firstName;
    private String lastName;
    private String date;
    private List<Parent> parents;
    private List<Child> children;

    public Child(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Child(String date) {
        this.date = date;
    }
}
