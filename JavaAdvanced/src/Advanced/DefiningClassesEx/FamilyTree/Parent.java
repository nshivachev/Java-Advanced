package Advanced.DefiningClassesEx.FamilyTree;

public class Parent extends Person {
    public Parent(String firstName, String lastName, String date) {
        super(firstName, lastName, date);
    }

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Parent(String date) {
        super(date);
    }
}
