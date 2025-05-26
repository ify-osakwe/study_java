package dsa.timBulchalka.sorting;

public class MergeSort {
    public static void main(String[] args) {

    }

    public static void merge(int[] array, int startIndex, int endIndex) {
        if (endIndex - startIndex < 2) {
            return;
        }
        int midIndex = (startIndex + endIndex) / 2;
        merge(array, startIndex, midIndex);
        merge(array, midIndex, endIndex);
    }
}
