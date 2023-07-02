package Advanced.DataStructuresWorkshop;

import java.util.Iterator;

public class SmartArray<E> implements Iterable<E>{
    private Object[] data;
    private int size;

    public SmartArray() {
        this.data = new Object[4];
        size = 0;
    }

    private class SmartArrayIterator implements Iterator<E> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            return get(i++);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SmartArrayIterator();
    }

    public void add(E element) {
        if (this.size == this.data.length) {
            this.data = grow();
        }

        this.data[size] = element;
        this.size++;
    }

    public void add(int index, E element) {
        validateIndex(index);

        int lastIndex = this.size - 1;
        E lastElement = get(lastIndex);

        for (int i = lastIndex; i < index; i--) {
            data[i] = data[i - 1];
        }

        this.data[index] = element;
        add(lastElement);
    }

    public E get(int index) {
        validateIndex(index);

        return (E) this.data[index];
    }

    public int size() {
        return this.size;
    }

    public E remove(int index) {
        validateIndex(index);
        this.size--;
        E element = get(index);

        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size] = null;

        if (this.data.length / 4 >= this.size || this.data.length / 4 == 4) {
            this.data = shrink();
        }
        return element;
    }

    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }

        return false;
    }

    private Object[] grow() {
        Object[] newData = new Object[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private Object[] shrink() {
        Object[] newData = new Object[this.data.length / 2];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

        //System.arraycopy(this.data, 0, newData, 0, this.size);

        return newData;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }
}
