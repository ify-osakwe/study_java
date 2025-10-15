package dsa.notes.optimise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A class to represent an item
class Item {
    int value;
    int weight;
    double ratio;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }

    @Override
    public String toString() {
        return "Value:" + this.value + ", Weight:" + this.weight;
    }
}

// KNAPSACK PROBLEM
public class GreedyMethod2 {
    public static void main(String[] args) {
        int capacity = 50;
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        ));

        double maxValue = solve(capacity, items);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }

    public static double solve(int capacity, List<Item> items) {
        // Step 1: Sort items by ratio in descending order
        items.sort((item1, item2) -> Double.compare(item2.ratio, item1.ratio));

        // Step 2: Initialize variables
        double totalValue = 0.0;
        int remainingCapacity = capacity;

        // Step 3: Loop through the sorted items
        for (Item currentItem : items) {
            if (currentItem.weight <= remainingCapacity) {
                totalValue += currentItem.value;
                remainingCapacity -= currentItem.weight;
            } else {
                double fraction = (double) remainingCapacity / currentItem.weight;
                totalValue += currentItem.value * fraction;
                remainingCapacity = 0;
                break; // The knapsack is now full. Exit the loop
            }
        }
        System.out.println("remaining capacaity" + remainingCapacity);
        return totalValue;
    }
}
