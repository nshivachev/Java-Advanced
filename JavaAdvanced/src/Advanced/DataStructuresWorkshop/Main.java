package Advanced.DataStructuresWorkshop;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        IntStream.rangeClosed(1, 10).forEach(smartArray::add);

        smartArray.forEach(System.out::println);


        MyStack<Integer> stack = new MyStack<>();

        IntStream.rangeClosed(1, 10).forEach(stack::push);

        System.out.println("peek: " + stack.peek());

        System.out.println("pop: " + stack.pop());

        System.out.println("peek: " + stack.peek());

        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}