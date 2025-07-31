package dsa.timBulchalka.sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(array, 10, 4);
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }

    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value : input) {
            countArray[getDigit(position, value, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int k = numItems - 1; k >= 0; k--) {
            temp[--countArray[getDigit(position, input[k], radix)]] = input[k];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
