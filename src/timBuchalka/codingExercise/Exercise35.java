package timBuchalka.codingExercise;

public class Exercise35 {
    public static void main(String[] args) {
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        one.subtract(number);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        number.subtract(one);
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    // Constructor with parameters
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to get real part
    public double getReal() {
        return real;
    }

    // Method to get imaginary part
    public double getImaginary() {
        return imaginary;
    }

    // Method to add real and imaginary parts
    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    // Method to add a ComplexNumber to this ComplexNumber
    public void add(ComplexNumber complexNumber) {
        this.real += complexNumber.real;
        this.imaginary += complexNumber.imaginary;
    }

    // Method to subtract real and imaginary parts
    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    // Method to subtract a ComplexNumber from this ComplexNumber
    public void subtract(ComplexNumber complexNumber) {
        this.real -= complexNumber.real;
        this.imaginary -= complexNumber.imaginary;
    }
}

