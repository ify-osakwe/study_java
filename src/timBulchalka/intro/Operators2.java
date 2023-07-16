package timBulchalka.intro;

public class Operators2 {
    public static void main(String[] args) {
        // Ternary Operator
        // a short form "if (statement) this else that"
        String makeOfCar = modelCar();
        boolean isAVolks = makeOfCar.equals("Volswagen") ? false : true;
        System.out.println(isAVolks);
    }

    static String modelCar() {
        return "Volks";
    }
}
