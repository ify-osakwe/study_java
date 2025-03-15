package timBuchalka.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Gen03 {
    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete", "50")
                .getMatches("Course", "Python");

        matches.sort(new LPAStudentComparator());
        printList(matches);

        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);
    }

    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
    }
}

interface QueryItem {

    boolean matchFieldValue(String fieldName, String value);
}

class QueryList<T extends Student & QueryItem> extends ArrayList<T> {

//    private List<T> items;

    public QueryList() {

    }

    public QueryList(List<T> items) {
        super(items);
//        this.items = items;
    }

    public static <S extends QueryItem> List<S> getMatches(List<S> items,
                                                           String field, String value) {
        List<S> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}

class Student implements QueryItem, Comparable<Student> {

    private static int LAST_ID = 10_000;
    private final int studentId;

    private final String name;
    private final String course;
    private final int yearStarted;

    protected static Random random = new Random();

    private static final String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static final String[] courses = {"C++", "Java", "Python"};

    public Student() {
        studentId = LAST_ID++;
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId, name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(studentId).compareTo(o.studentId);
    }
}

class LPAStudent extends Student {

    private final double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Integer.parseInt(value);
        }

        return super.matchFieldValue(fieldName, value);
    }
}

class LPAStudentComparator implements Comparator<LPAStudent> {

    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) (o1.getPercentComplete() - o2.getPercentComplete());
    }
}
