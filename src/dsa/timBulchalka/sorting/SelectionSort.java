package dsa.timBulchalka.sorting;

import dsa.utils.DsaUtils;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int index = 1; index <= lastUnsortedIndex; index++) {
                if (intArray[index] > intArray[largest]) {
                    largest = index;
                }
            }
            DsaUtils.swapIndex(intArray, largest, lastUnsortedIndex);
        }

        System.out.println(Arrays.toString(intArray));
    }
}
