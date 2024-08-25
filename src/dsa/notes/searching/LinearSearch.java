package dsa.notes.searching;

/**
 * Implementation of linear search on an ordered array/list
 * Time complexity is O(N)
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] collection = {1, 3, 5, 7, 9};
        System.out.println(linearSearch(collection, 5));  // Output: 2
        System.out.println(linearSearch(collection, 8));

        String[] stringCollection = {"apple", "banana", "cherry", "date"};
        System.out.println(linearSearch(stringCollection, "cherry"));  // Output: 2
        System.out.println(linearSearch(stringCollection, "grape"));
    }

    public static int linearSearch(int[] array, int value) {
        for (int index = 0; index < array.length; index++) {
            int element = array[index];
            if (element == value) {
                return index;
            } else if (element > value) {
                break;
            }
        }
        return 0;
    }

    public static <T extends Comparable<T>> int linearSearch(T[] collection, T searchValue) {
        // Implementation of linear search on an ordered array/list with generic types
        for (int index = 0; index < collection.length; index++) {
            T element = collection[index];
            if (element.compareTo(searchValue) == 0) {
                return index;
            } else if (element.compareTo(searchValue) > 0) {
                break;
            }
        }
        return 0;
    }
}
