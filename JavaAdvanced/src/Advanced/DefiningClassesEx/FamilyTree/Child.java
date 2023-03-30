package Advanced.DefiningClassesEx.FamilyTree;

public class Child extends Person {
    public Child(String firstName, String lastName, String date) {
        super(firstName, lastName, date);
    }

    public Child(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Child(String date) {
        super(date);
    }
}
