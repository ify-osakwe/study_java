package timBuchalka.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Nested03 {
    public static void main(String[] args) {
        List<EmployeeF> employees = new ArrayList<>(List.of(
                new EmployeeF(10001, "Ralph", 2015),
                new EmployeeF(10005, "Carole", 2021),
                new EmployeeF(10022, "Jane", 2013),
                new EmployeeF(13151, "Laura", 2020),
                new EmployeeF(10050, "Jim", 2018)));

        employees.sort(new EmployeeF.EmployeeComparator<>("yearStarted")
                .reversed());

        for (EmployeeF e : employees) {
            System.out.println(e);
        }

        System.out.println("Store Members");

        List<StoreEmployeeF> storeEmployees = getStoreEmployees();

        for (StoreEmployeeF e : storeEmployees) {
            System.out.println(e);
        }

        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);
    }

    private static List<StoreEmployeeF> getStoreEmployees() {
        List<StoreEmployeeF> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployeeF(10015, "Meg", 2019,
                        "Target"),
                new StoreEmployeeF(10515, "Joe", 2021,
                        "Walmart"),
                new StoreEmployeeF(10105, "Tom", 2020,
                        "Macys"),
                new StoreEmployeeF(10215, "Marty", 2018,
                        "Walmart"),
                new StoreEmployeeF(10322, "Bud", 2016,
                        "Target")));

        var comparator = new StoreEmployeeF().new StoreComparator<>();
        storeEmployees.sort(comparator);
        return storeEmployees;
    }

    // AN EXAMPLE OF A LOCAL NESTED CLASS
    public static void addPigLatinName(List<? extends StoreEmployeeF> list) {
        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployeeF
                implements Comparable<DecoratedEmployee> {

            private final String pigLatinName;
            private final EmployeeF originalInstance;

            public DecoratedEmployee(String pigLatinName, EmployeeF originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (var dEmployee : newList) {
            System.out.println(dEmployee.originalInstance.getName() + " "
                    + dEmployee.pigLatinName);
        }
    }
}

class StoreEmployeeF extends EmployeeF {

    private String store;

    public StoreEmployeeF() {
    }

    public StoreEmployeeF(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s%s".formatted(store, super.toString());
    }

    public class StoreComparator<T extends StoreEmployeeF>
            implements Comparator<StoreEmployeeF> {

        @Override
        public int compare(StoreEmployeeF o1, StoreEmployeeF o2) {
            int result = o1.store.compareTo(o2.store);
            if (result == 0) {
                return new EmployeeF.EmployeeComparator<>(
                        "yearStarted").compare(o1, o2);
            }
            return result;
        }
    }

}

class EmployeeF {

    public static class EmployeeComparator<T extends EmployeeF>
            implements Comparator<EmployeeF> {

        private String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(EmployeeF o1, EmployeeF o2) {

            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }

            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    public EmployeeF() {
    }

    public EmployeeF(int employeeId, String name, int yearStarted) {
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