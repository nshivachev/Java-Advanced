package Advanced.IteratorsAndComparatorsEx.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int firstPersonNameLength = first.getName().length();
        int secondPersonNameLength = second.getName().length();

        if (firstPersonNameLength == secondPersonNameLength) {
            char firstPersonChar = first.getName().toLowerCase().charAt(0);
            char secondPersonChar = second.getName().toLowerCase().charAt(0);
            return Character.compare(firstPersonChar, secondPersonChar);
        }
        return Integer.compare(firstPersonNameLength, secondPersonNameLength);
    }
}
