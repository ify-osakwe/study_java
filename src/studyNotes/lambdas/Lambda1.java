package studyNotes.lambdas;

interface MyNumber {
    double getValue();
}


public class Lambda1 {
    public static void main(String[] args) {
        MyNumber myNumber;
        myNumber = () -> 123.45;
        System.out.println("A fixed value: " + myNumber.getValue());

        myNumber = () -> Math.random() * 100;
        System.out.println("A random value: " + myNumber.getValue());
        System.out.println("Another random value: " + myNumber.getValue());

        // ERROR!!
        // myNumber = () -> "123.33";
    }
}
