package timBulchalka.classes;

public class Nested02 {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);
    }
}

// AN EXAMPLE OF A INNER/INSTANCE NESTED CLASS
class Meal {

    private final double price = 5.0;
    private final Item burger;
    private final Item drink;
    private final Item side;

    private final double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Item("regular", "burger");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {

        double total = burger.price + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
                "Total Due: ", getTotal());
    }

    private class Item {

        private final String name;
        private final String type;
        private final double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

}
