package designPatterns.behavioural.interpreter;

class InterpreterContext {
    public String getBinaryFormat(int i) {
        return Integer.toBinaryString(i);
    }

    public String getHexadecimalFormat(int i) {
        return Integer.toHexString(i);
    }
}

interface Expression {
    String interpret(InterpreterContext context);
}

class IntToBinaryExpression implements Expression {
    private int i;

    public IntToBinaryExpression(int c) {
        i = c;
    }

    @Override
    public String interpret(InterpreterContext context) {
        return context.getBinaryFormat(i);
    }
}

class IntToHexExpression implements Expression {
    private int i;

    public IntToHexExpression(int c) {
        i = c;
    }

    @Override
    public String interpret(InterpreterContext context) {
        return context.getHexadecimalFormat(i);
    }
}

class InterpreterClient {
    private InterpreterContext context;

    public InterpreterClient(InterpreterContext context) {
        this.context = context;
    }

    public String interpret(String string) {
        Expression expression;
        int parsedInt = Integer.parseInt(string.substring(0, string.indexOf(" ")));
        if (string.contains("Hexadecimal")) {
            expression = new IntToHexExpression(parsedInt);
        } else if (string.contains("Binary")) {
            expression = new IntToBinaryExpression(parsedInt);
        } else {
            return string;
        }
        return expression.interpret(context);
    }
}


public class InterpreterPattern {
    public static void main(String[] args) {
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";

        InterpreterClient ec = new InterpreterClient(new InterpreterContext());
        System.out.println(str1 + " = " + ec.interpret(str1));
        System.out.println(str2 + " = " + ec.interpret(str2));
    }
}
