package timBuchalka.javaDataStructures.arrays;

import java.util.Arrays;

public class Array01 {
    public static void main(String[] args) {
        // the size of an array is fixed in Java.
        int[] myIntArray = new int[10];
        System.out.println(Arrays.toString(myIntArray));

        // array initializer makes the job of instantiating and initializing
        // a small array, much easier.
        // elements in an array have the default value when you do not initialize them.
        int[] myIntArray2 = new int[]{1, 5, 7, 9, 3};
        System.out.println(Arrays.toString(myIntArray2));
        System.out.println();

        for (int i=0; i< myIntArray2.length; i++) {
            System.out.println("Index " + i + " = " + myIntArray2[i]);
        }

        for (int element: myIntArray2) {
            System.out.print(element + " ");
        }
    }
}
