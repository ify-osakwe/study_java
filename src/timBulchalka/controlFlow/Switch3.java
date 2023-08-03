package timBulchalka.controlFlow;

public class Switch3 {
    public static void main(String[] args) {
        System.out.println(getNatoAlphabet('d'));
    }

    public static String getNatoAlphabet(char c) {
        return switch (c) {
            case 'A' -> "Able";
            case 'B' -> "Baker";
            case 'C' -> "Charlie";
            case 'D' -> "Dog";
            case 'E' -> "Easy";
            default -> "Not found";
        };
    }
}
