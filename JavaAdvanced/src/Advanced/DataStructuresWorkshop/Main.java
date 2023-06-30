package Advanced.DataStructuresWorkshop;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        IntStream.rangeClosed(1, 10).forEach(smartArray::add);

        smartArray.forEach(System.out::println);
    }
}