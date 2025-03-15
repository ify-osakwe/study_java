package timBuchalka.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Nested04 {
    public static void main(String[] args) {
        EmployeeK e1 = new EmployeeK("Minnie" , "Mouse", "01/02/2015");
        EmployeeK e2 = new EmployeeK("Mickie" , "Mouse", "05/08/2000");
        EmployeeK e3 = new EmployeeK("Daffy" , "Duck", "11/02/2011");
        EmployeeK e4 = new EmployeeK("Daisy" , "Duck", "05/03/2013");
        EmployeeK e5 = new EmployeeK("Goofy" , "Dog", "23/07/2020");

        List<EmployeeK> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

        printOrderedList(list, "name");
        System.out.println();
        printOrderedList(list, "year");
    }

    public static void printOrderedList(List<EmployeeK> eList, String sortField) {

        int currentYear = LocalDate.now().getYear();

        class MyEmployee {

            final EmployeeK containedEmployee;
            final int yearsWorked;
            final String fullName;

            public MyEmployee(EmployeeK containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ",
                        containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(
                        fullName, yearsWorked);
            }
        }

        List<MyEmployee> list = new ArrayList<>();
        for (EmployeeK employee : eList) {
            list.add(new MyEmployee(employee));
        }

        var comparator = new Comparator<MyEmployee>() {
            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equals("name")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);
        for (MyEmployee myEmployee : list) {
            System.out.println(myEmployee);
        }
    }
}

record EmployeeK(String first, String last, String hireDate) {
}