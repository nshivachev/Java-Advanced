package Advanced.GenericsEx.CustomListIterator;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
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

    public long countGreaterValuesThan(T value) {
        return values.stream().filter(valuesList -> valuesList.compareTo(value) > 0).count();
    }

    public T max() {
        return values.stream().max(Comparable::compareTo).get();
    }

    public T min() {
        return values.stream().min(Comparable::compareTo).get();
    }

    public void printValues() {
        iterator().forEachRemaining(System.out::println);
    }

    public int size() {
        return values.size();
    }

    public T get(int index) {
        return values.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        values.forEach(value -> stringBuilder.append(String.format("%s%n", value.toString())));
        return stringBuilder.toString().trim();
    }
}
