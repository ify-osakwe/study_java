package dsa.timBulchalka.array;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        intArray[0] = 20;
        intArray[1] = 40;
        intArray[2] = 50;
        intArray[3] = 60;

        System.out.println(Arrays.toString(intArray));

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " = " + intArray[i]);
        }
    }
}
