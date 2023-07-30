package timBulchalka.functions;

public class Method6 {
    public static void main(String[] args) {
        /*
         * Method overloading occurs when a class has multiple methods, with the same name,
         * but the methods are declared with different parameters.
         *
         * A method signature consist of the name of the method, and the uniqueness of the declaration
         * of its parameters.
         *
         * A method's return type is not part of the signature.
         * A parameter name is also not part of the signature.
         *
         * The type, order, and number of parameters, in conjunction with the name,
         * make a method signature unique
         */
        calculateScore("Tim", 500);
        calculateScore(300);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }
}
