package playground.bcs;

import java.util.HashSet;

public class A3April2022 {
    public static void main(String[] args) {
        //twoLargestNumbers();
        //findDuplicate();
    }

    public static void largestNumber() {
        int[] arr = {11, 97, 23, 37, 30};
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Largest number: " + max);
    }


    public static void twoLargestNumbers() {
        int[] array = {11, 97, 23, 37, 30};
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        System.out.println("Two largest numbers: " + firstMax + ", " + secondMax);
    }


    public static void findDuplicate() {
        int[] arr = {11, 37, 23, 37, 30};
        HashSet<Integer> set = new HashSet<>();
        int duplicate = -1;

        for (int num : arr) {
            if (!set.add(num)) {
                duplicate = num;
                break;
            }
        }

        System.out.println("Duplicate value: " + duplicate);
    }


}
