package Advanced.GenericsEx.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        values = new ArrayList<>();
    }

    public void add(T value) {
        values.add(value);
    }

    public void remove(int index) {
        values.remove(index);
    }

    public void contains(T value) {
        System.out.println(values.contains(value));
    }

    public void swap(int index1, int index2) {
        Collections.swap(values, index1, index2);
    }

    public void printGreaterValuesCount(T value) {
        System.out.println(values.stream().filter(valuesList -> valuesList.compareTo(value) > 0).count());
    }

    public void printMaxValue() {
        System.out.println(values.stream().max(Comparable::compareTo).get());
    }

    public void printMinValue() {
        System.out.println(values.stream().min(Comparable::compareTo).get());
    }

    public void printValues() {
        values.forEach(System.out::println);
    }
}
