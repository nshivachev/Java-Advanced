package Advanced.GenericsLab.GenericScale;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        T greater;

        if (left.compareTo(right) > 0) {
            greater = left;
        } else if (left.compareTo(right) < 0) {
            greater = right;
        } else {
            greater = null;
        }

        return greater;
    }
}
