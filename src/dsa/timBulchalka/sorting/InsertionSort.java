package dsa.timBulchalka.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int index;
            for (index = firstUnsortedIndex; index > 0 && array[index - 1] > newElement; index--) {
                array[index] = array[index - 1];
            }
            array[index] = newElement;
        }

        System.out.println(Arrays.toString(array));
    }
}
