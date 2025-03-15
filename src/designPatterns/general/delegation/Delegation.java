package designPatterns.general.delegation;

class RealPrinter {
    void print() {
        System.out.println("The Delegate");
    }
}

class Printer {
    RealPrinter realPrinter = new RealPrinter();

    void print() {
        realPrinter.print();
    }
}

public class Delegation {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
    }
}
