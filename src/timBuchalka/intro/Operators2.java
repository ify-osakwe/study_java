package timBuchalka.intro;

public class Operators2 {
    public static void main(String[] args) {
        // Ternary Operator
        // a short form "if (statement) this else that"
        String makeOfCar = modelCar(0);
        boolean isAVolks = makeOfCar.equals("Volkswagen") ? false : true;
        System.out.println(isAVolks);
    }

    static String modelCar(int code) {
        if (code == 0) return "";
        else return "Volks";

    }
}
