package designPatterns.structural.composite;

public interface EmployeeP {
    void showEmployeeDetails();
}

class DeveloperP implements EmployeeP {
    private String name;
    private long employeeId;
    private String position;

    public DeveloperP(String name, long employeeId, String position) {
        this.name = name;
        this.employeeId = employeeId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(employeeId + " " + name + " " + position);
    }
}

class ManagerP implements EmployeeP {
    private String name;
    private long employeeId;
    private String position;

    public ManagerP(String name, long employeeId, String position) {
        this.name = name;
        this.employeeId = employeeId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(employeeId + " " + name + " " + position);
    }
}
