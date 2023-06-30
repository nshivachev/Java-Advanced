package Advanced.DataStructuresWorkshop;

import java.util.function.Consumer;

public class SmartArray {
    private Integer[] data;
    private int size;

    public SmartArray() {
        this.data = new Integer[4];
        size = 0;
    }

    public void add(int element) {
        if (this.size == this.data.length) {
            this.data = grow();
        }

        this.data[size] = element;
        this.size++;
    }

    public void add(int index, int element) {
        validateIndex(index);

        int lastIndex = this.size - 1;
        int lastElement = this.data[lastIndex];

        for (int i = lastIndex; i < index; i--) {
            data[i] = data[i - 1];
        }

        this.data[index] = element;
        add(lastElement);
        this.size++;
    }

    public int get(int index) {
        validateIndex(index);

        return this.data[size];
    }

    public int size() {
        return this.size;
    }

    public int remove(int index) {
        validateIndex(index);
        this.size--;
        int element = this.data[index];

        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size] = null;

        if (this.data.length / 4 >= this.size || this.data.length / 4 == 4) {
            this.data = shrink();
        }
        return element;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }

        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private Integer[] grow() {
        Integer[] newData = new Integer[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private Integer[] shrink() {
        Integer[] newData = new Integer[this.data.length / 2];

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
