package timBulchalka.QnA;

import timBulchalka.UtilsX;

public class QA3 {
    public static void main(String[] args) {
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;

        System.out.println(minByte + " = minimum Byte");
        System.out.println(maxByte + " = maximum Byte");
        UtilsX.newLine();

        byte aByte = (byte) (minByte / 2);
        System.out.println("(minByte / 2) = " + aByte);

        byte bByte =(byte) Byte.MAX_VALUE / 2;
        System.out.println("Byte.MAX_VALUE / 2 = " + bByte);
    }
}
