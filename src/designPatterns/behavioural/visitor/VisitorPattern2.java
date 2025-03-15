package designPatterns.behavioural.visitor;

import java.util.ArrayList;

interface VisitableL {
    void accept(VisitorL visitor);
}

class BookL implements VisitableL {
    private double price;
    private double weight;

    public BookL(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(VisitorL visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}

class CD implements VisitableL {
    private double price;
    private double weight;

    public CD(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public void accept(VisitorL visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}

class DVD implements VisitableL {
    private double price;
    private double weight;

    public DVD(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public void accept(VisitorL visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}

interface VisitorL {
    void visit(BookL book);

    void visit(CD cd);

    void visit(DVD dvd);

    double getTotalPostage();
}

class USPostageVisitor implements VisitorL {
    private double totalPostageForCart = 0;


    public void visit(BookL book) {
        //assume we have a calculation here related to weight and price,
        // free postage for a book over 20
        if (book.getPrice() < 20.0) {
            totalPostageForCart += book.getWeight() * 2;
        }
    }

    public void visit(CD cd) {
        if (cd.getPrice() < 20.0) {
            totalPostageForCart += cd.getWeight() * 2.5;
        }
    }

    public void visit(DVD dvd) {
        if (dvd.getPrice() < 20.0) {
            totalPostageForCart += dvd.getWeight() * 3;
        }
    }

    //return the internal state
    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

class SouthAmericaPostageVisitor implements VisitorL {
    private double totalPostageForCart = 0;

    //collect data about the book
    public void visit(BookL book) {
        //assume we have a calculation here related to weight and price free postage for a book over 10
        if (book.getPrice() < 30.0) {
            totalPostageForCart += (book.getWeight() * 2) * 2;
        }
    }

    //add other visitors here
    public void visit(CD cd) {
        if (cd.getPrice() < 30.0) {
            totalPostageForCart += (cd.getWeight() * 2.5) * 2;
        }
    }

    public void visit(DVD dvd) {
        if (dvd.getPrice() < 30.0) {
            totalPostageForCart += (dvd.getWeight() * 3) * 2;
        }
    }

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

public class VisitorPattern2 {
    private static ArrayList<VisitableL> items = new ArrayList<>();

    public static double calculatePostage(VisitorL visitor) {
        //iterate through all items
        for (VisitableL item : items) {
            item.accept(visitor);
        }
        return visitor.getTotalPostage();
    }

    public static void main(String[] args) {
        // create a bunch of visitors (Book, CD, and DVD)
        VisitableL myBook = new BookL(8.52, 1.05);
        VisitableL myCD = new CD(18.52, 3.05);
        VisitableL myDVD = new DVD(6.53, 4.02);

        // add each vistor to the array list
        items.add(myBook);
        items.add(myCD);
        items.add(myDVD);

        VisitorL visitor = new USPostageVisitor();
        double myPostage = calculatePostage(visitor);
        System.out.println("The total postage for my items shipped to the US is: " + myPostage);

        visitor = new SouthAmericaPostageVisitor();
        myPostage = calculatePostage(visitor);
        System.out.println("The total postage for my items shipped to South America is: " + myPostage);
    }
}
