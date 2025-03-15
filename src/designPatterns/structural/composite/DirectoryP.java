package designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

class DirectoryP implements EmployeeP {
    private List<EmployeeP> employeeList = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        for (EmployeeP employee : employeeList) {
            employee.showEmployeeDetails();
        }
    }

    public void addEmployee(EmployeeP employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(EmployeeP employee) {
        employeeList.remove(employee);
    }
}


class ClientP {
    public static void main(String[] args) {
        EmployeeP dev1 = new DeveloperP("John Doe", 100, "Senior");
        EmployeeP dev2 = new DeveloperP("Jane Doe", 200, "Intermediate");

        DirectoryP engineeringDirectory = new DirectoryP();
        engineeringDirectory.addEmployee(dev1);
        engineeringDirectory.addEmployee(dev2);

        EmployeeP man1 = new ManagerP("Jack Doe", 101, "CIO");
        EmployeeP man2 = new ManagerP("Jean Doe", 101, "CFO");

        DirectoryP accountDirectory = new DirectoryP();
        accountDirectory.addEmployee(man1);
        accountDirectory.addEmployee(man2);

        DirectoryP companyDirectory = new DirectoryP();
        companyDirectory.addEmployee(engineeringDirectory);
        companyDirectory.addEmployee(accountDirectory);
        companyDirectory.showEmployeeDetails();


    }
}