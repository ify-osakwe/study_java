package timBuchalka.QnA;

public class QA1 {
    public static void main(String[] args) {

    }
}

class Student {
    String name;
    String department;

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

/**
 *
 * Hi Yuxuanthe 'this' key word is used to refer to the instance of a class, and it used when you want to show a separation between a parameter and the instance of a class as shown in the code below
 *
 * class Student {
 *     String name;
 *     String department;
 *
 *     public Student(String name, String department) {
 *         this.name = name;
 *         this.department = department;
 *     }
 *
 *     public void setDepartment(String department) {
 *         this.department = department;
 *     }
 *
 *     public String getDepartment() {
 *         return department;
 *     }
 * }
 *
 * if you want to use less of the 'this' keyword, just make sure, whatever parameters you are passing in a constructor or function does not have the same 'name' as the field/property in the class.I hope this answers your question
 */