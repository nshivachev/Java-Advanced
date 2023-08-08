package Advanced.IteratorsAndComparatorsEx.LinkedListTraversal;

import java.util.Iterator;

public class SmartArray<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    public SmartArray() {
        data = new Object[4];
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                return (E) data[i++];
            }
        };
    }

    public void add(E element) {
        if (size == data.length) {
            data = grow();
        }

        data[size] = element;
        size++;
    }

    public void remove(E element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                size--;

                for (int j = i; j < size; j++) {
                    data[j] = data[j + 1];
                }

                data[size] = null;

                if (data.length / 4 >= size || data.length / 4 == 4) {
                    data = shrink();
                }

                break;
            }
        }
    }

    public int getSize() {
        return size;
    }

    private Object[] grow() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);

        return newData;
    }

    private Object[] shrink() {
        Object[] newData = new Object[this.data.length / 2];

        System.arraycopy(data, 0, newData, 0, size);

        return newData;
    }
}
