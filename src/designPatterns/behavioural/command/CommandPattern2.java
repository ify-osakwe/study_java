package designPatterns.behavioural.command;

import java.util.ArrayList;
import java.util.List;

interface Order {
    void execute();
}

class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("Stock bought: NAME: " + name + " QUANTITY: " + quantity);
    }

    public void sell() {
        System.out.println("Stock sold: NAME: " + name + " QUANTITY: " + quantity);
    }
}

class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.buy();
    }
}

class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.sell();
    }
}

class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}

public class CommandPattern2 {
    public static void main(String[] args) {
        Stock stock = new Stock("Google", 1000);
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}
