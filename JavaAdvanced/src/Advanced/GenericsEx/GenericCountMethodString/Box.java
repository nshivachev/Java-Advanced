package Advanced.GenericsEx.GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T value) {
        values.add(value);
    }

    public long countGreaterElements(T element) {
        return values.stream().filter(valuesFromList -> valuesFromList.compareTo(element) > 0).count();
    }
}
