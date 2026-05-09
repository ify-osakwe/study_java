package dsa.grokbook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Fruits into Baskets.
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits
 * in each basket. The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e.,
 * you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both the baskets.
 */
public class SlideWindow4 {
    public static void main(String[] args) {
        char[] arr1 = {'A', 'B', 'C', 'A', 'C'};
        char[] arr2 = {'A', 'B', 'C', 'B', 'B', 'C'};

        System.out.println("Maximum number of fruits: " + findLength(arr1));
        System.out.println("Maximum number of fruits: " + findLength(arr2));
    }

    // time complexity is O(N)
    // space complexity is O(1)
    private static int findLength(char[] array) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            fruitFreqMap.put(array[windowEnd], fruitFreqMap.getOrDefault(array[windowEnd], 0) + 1);
            while (fruitFreqMap.size() > 2) {
                fruitFreqMap.put(array[windowStart], fruitFreqMap.get(array[windowStart]) - 1);
                if (fruitFreqMap.get(array[windowStart]) == 0) {
                    fruitFreqMap.remove(array[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
