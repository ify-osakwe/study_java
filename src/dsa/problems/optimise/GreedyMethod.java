package dsa.problems.optimise;

import java.util.*;

class Activity {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "[" + this.start + ", " + this.finish + "]";
    }
}

// ACTIVITY SELECTION PROBLEM
public class GreedyMethod {
    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>(Arrays.asList(
                new Activity(1, 4), new Activity(3, 5), new Activity(0, 6),
                new Activity(5, 7), new Activity(6, 10), new Activity(8, 11)
        ));

        List<Activity> result = findMaxActivities(activities);
        System.out.println("Selected activities: " + result);
    }

    public static List<Activity> findMaxActivities(List<Activity> activities) {
        // Step 1: Sort activities by finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));

        // Step 2: Create a solution list
        List<Activity> solution = new ArrayList<>();
        if (activities.isEmpty()) {
            return solution;
        }

        // Add the first activity
        Activity lastActivity = activities.get(0);
        solution.add(activities.get(0));

        // Step 3: Loop through the rest of the activities
        // Start from the second activity (index 1)
        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            if (currentActivity.start >= lastActivity.finish) {
                solution.add(currentActivity);
                lastActivity = currentActivity;
            }
        }
        return solution;
    }
}
