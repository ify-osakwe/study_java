package timBuchalka.classes;

public class StudentMain {
    public static void main(String[] args) {
        Student student = new Student("ER302", "Jon",
                "11/11/1990", "Java Masterclass");
        System.out.println(student);

        UniStudent student1 = new UniStudent("ER302", "Jon",
                "11/11/1990", "Java Masterclass");
        System.out.println(student1);
    }
}
