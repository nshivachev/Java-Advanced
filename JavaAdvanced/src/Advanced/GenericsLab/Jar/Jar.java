package Advanced.GenericsLab.Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements = new ArrayDeque<>();

    public void add(T element) {
        elements.push(element);
    }

    public T remove() {
        return elements.pop();
    }
}
