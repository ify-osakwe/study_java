package timBuchalka.intro;

public class Operators {
    public static void main(String[] args) {
        /*
         * Operators in Java are special symbols that perform specific operations
         * on one, two or three operands, and then return a result
         *
         * ... = assignment operator
         * ... + plus operator
         * ... % modulus or remainder operator
         * ... * multiplication
         * ... / division
         * ... variable++ postfix increment operator
         * ... variable-- postfix decrement operator
         */
        int aResult = 4 + 5;
        System.out.println(aResult);

        int bResult = 10 % 3; // answer is 1
        System.out.println(bResult + "\n");

        int aNumber = 40;
        aNumber += 1;
        //int bNumber = aNumber++;
        System.out.println("aNumber = " + aNumber);
        //System.out.println("bNumber = " + bNumber + "\n");

        int cNumber = aNumber++;
        System.out.println(cNumber);
    }
}
