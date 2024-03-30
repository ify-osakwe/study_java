package timBulchalka.javaDataStructures.arrays;

import java.util.Arrays;

import static timBulchalka.UtilsX.getRandomArray;
import static timBulchalka.UtilsX.newLine;

public class Array02 {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = getRandomArray(15);
        System.out.println(Arrays.toString(secondArray));

        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));
        newLine();

        int[] thirdArray = getRandomArray(9);
        System.out.println("thirdArray " + Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println("fourthArray " + Arrays.toString(fourthArray));

        int[] fifthArray = Arrays.copyOf(thirdArray, 5);
        System.out.println("fifthArray " + Arrays.toString(fifthArray));

        int[] sixthArray = Arrays.copyOf(thirdArray, 12);
        System.out.println("sixthArray " + Arrays.toString(sixthArray));

    }


}
