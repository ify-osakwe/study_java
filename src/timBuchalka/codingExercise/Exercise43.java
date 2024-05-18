package timBuchalka.codingExercise;

public class Exercise43 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array = " + java.util.Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array = " + java.util.Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        System.out.println("Array = " + java.util.Arrays.toString(array));

        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        System.out.println("Reversed array = " + java.util.Arrays.toString(array));
    }

    private static void reverse2(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
