package Advanced.GenericsEx.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        values.forEach(value -> stringBuilder.append(String.format("%s: %s%n", value.getClass().getName(), value)));

        return stringBuilder.toString();
    }
}
