package studyNotes.lambdas;

interface StringOpFun {
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str) {
        StringBuilder result = new StringBuilder();
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result.append(str.charAt(i));
        return result.toString();
    }

    String removeSpaces(String str) {
        StringBuilder result = new StringBuilder();
        int i;
        for (i = 0; i < str.length(); i++)
            if (str.charAt(i) != ' ')
                result.append(str.charAt(i));
        return result.toString();
    }
}


public class Lambda8 {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);

        MyStringOps myStringOps = new MyStringOps();
        outStr = stringOp(myStringOps::removeSpaces, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("spaces removed: " + outStr);
    }
}
