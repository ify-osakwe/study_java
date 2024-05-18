package timBuchalka.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Nested00 {
    public static void main(String[] args) {
        List<Employee2> employees = new ArrayList<>(List.of(
                new Employee2(10001, "Ralph", 2015),
                new Employee2(10005, "Carole", 2021),
                new Employee2(10022, "Jane", 2013),
                new Employee2(13151, "Laura", 2020),
                new Employee2(10050, "Jim", 2018)));

        employees.sort(new Employee2.EmployeeComparator<>("yearStarted")
                .reversed());

        for (Employee2 e : employees) {
            System.out.println(e);
        }

    }
}

// AN EXAMPLE OF A STATIC NESTED CLASS
class Employee {

    public static class EmployeeComparator<T extends Employee>
            implements Comparator<Employee> {

        private final String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {

            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }

            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
