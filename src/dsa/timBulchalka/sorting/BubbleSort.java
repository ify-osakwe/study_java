package dsa.timBulchalka.sorting;

import dsa.utils.DsaUtils;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int index = 0; index < lastUnsortedIndex; index++) {
                if (intArray[index] > intArray[index + 1]) {
                    DsaUtils.swapIndex(intArray, index, index + 1);
                }
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(intArray));

    }
}
