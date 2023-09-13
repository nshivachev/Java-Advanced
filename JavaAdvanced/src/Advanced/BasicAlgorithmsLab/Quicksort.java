package Advanced.BasicAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int array[] = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(array);

        printArray(array);
    }

    private static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex);

            sort(array, lowIndex, partitionIndex - 1);
            sort(array, partitionIndex + 1, highIndex);
        }
    }

    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int i = (lowIndex - 1);

        for (int j = lowIndex; j < highIndex; j++) {
            if(array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[highIndex];
        array[highIndex] = temp;

        return i + 1;
    }

    private static void printArray(int array[]) {
        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }
}
