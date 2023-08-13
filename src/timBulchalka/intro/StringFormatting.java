package timBulchalka.intro;

public class StringFormatting {
    public static void main(String[] args) {
        // The Formatter class defines the notation for printf arguments
        // There is also a String.format() & formatted method that formats string
        int age = 30;
        System.out.printf("Your age is %d\n", age);

        int yearOfBirth = 2023 - age;
        System.out.printf("Age= %d, Birth year = %d%n", age, yearOfBirth);

        double price = 32.4567832;
        System.out.printf("Price %f", price);
        System.out.printf(" - to 3d.p. =  %.3f%n", price);

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);
    }
}
