package Advanced.BasicAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int array[] = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(array);

        printArray(array);
    }

    private static int[] mergeSort(int array[]) {
        if (array.length == 1) {
            return array;
        }

        int halfIndex = array.length / 2;

        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = firstArrayLength; i < array.length; i++) {
            secondPartition[i - firstArrayLength] = array[i];
        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        merge(array, firstPartition, secondPartition);

        return array;
    }

    private static void merge(int[] array, int[] firstPartition, int[] secondPartition) {
        int mainIndex = 0;

        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstPartition.length && secondPartitionIndex < secondPartition.length) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];
                secondPartitionIndex++;
            }

            mainIndex++;
        }

        while (firstPartitionIndex < firstPartition.length) {
            array[mainIndex] = firstPartition[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondPartition.length) {
            array[mainIndex] = secondPartition[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }
    }

    private static void printArray(int array[]) {
        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }
}