package Advanced.IteratorsAndComparatorsEx.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<Integer> {
        private int index = 0;
        private boolean isFirstRound = true;

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            int number = numbers.get(index);
            index += 2;

            if (index >= numbers.size() && isFirstRound) {
                index = 1;
                isFirstRound = false;
            }

            return number;
        }
    }
}
