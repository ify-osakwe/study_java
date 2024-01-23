package designPatterns.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    void pay(int amount);


}

class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }
}

class PaypalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PaypalStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with Paypal");
    }
}

class ItemD {
    private String upcCode;
    private int price;

    public ItemD(String upcCode, int price) {
        this.upcCode = upcCode;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class ShoppingCart {
    List<ItemD> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(ItemD item) {
        this.items.add(item);
    }

    public void removeItem(ItemD item) {
        this.items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (ItemD item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}

/**
 * <p> Examples in JDK: Collections.sort() method
 */
public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        ItemD item1 = new ItemD("1234", 10);
        ItemD item2 = new ItemD("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("jaja@yahoo.com", "10ab"));

        cart.pay(new CreditCardStrategy("Jaja", "1234 5678", "655", "07/2024"));

    }
}
