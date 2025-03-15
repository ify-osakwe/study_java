package designPatterns.behavioural.mediator;

import java.util.ArrayList;

interface Mediator {
     void addBuyer(Buyer buyer);
     void findHighestBidder();
}

class AuctionMediator implements Mediator {
    private ArrayList<Buyer> buyers;

    public AuctionMediator() {
        buyers = new ArrayList<>();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
        System.out.println(buyer.name + " was added to the buyers list.");
    }

    @Override
    public void findHighestBidder() {
        int maxBid = 0;
        Buyer winner = null;

        for (Buyer a : buyers) {
            if (a.price > maxBid) {
                maxBid = a.price;
                winner = a;
            }
        }

        System.out.println("The auction winner is " + winner.name +  ". He paid " + winner.price + "$ for the item.");

        for (Buyer a : buyers) {
            a.auctionHasEnded();
        }
    }
}


abstract class Buyer {
    // this class holds the buyer
    protected Mediator mediator;
    protected String name;
    protected int price;

    public Buyer(Mediator med, String name)  {
        this.mediator = med;
        this.name = name;
    }

    public abstract void bid(int price);
    public abstract void cancelTheBid();
    public abstract void auctionHasEnded();
}

class AuctionBuyer extends Buyer {
    // implementation of the bidding process.  There is an option to bid and an option to  cancel the bidding
    public AuctionBuyer(Mediator mediator,  String name)   {
        super(mediator, name);
    }

    @Override
    public void bid(int price)  {
        this.price = price;
    }

    @Override
    public void cancelTheBid() {
        this.price = -1;
    }

    @Override
    public void auctionHasEnded() {
        System.out.println("Received message that the auction is over: " + name);
    }
}


public class MediatorPattern2 {
    public static void main(String[] args) {
        AuctionMediator med = new AuctionMediator();

        Buyer b1 = new AuctionBuyer(med, "Jason");
        Buyer b2 = new AuctionBuyer(med, "Ian");
        Buyer b3 = new AuctionBuyer(med, "Myra");

        // Crate and add buyers
        med.addBuyer(b1);
        med.addBuyer(b2);
        med.addBuyer(b3);

        System.out.println("Welcome to the auction. Tonight  we are selling a vacation to Vegas.  please Bid your offers.");
        System.out.println("-----------------------------------------------");

        System.out.println("Waiting for the buyer's offers...");

        // Making bids
        b1.bid(1800);
        b2.bid(2000);
        b3.bid(780);

        System.out.println("-----------------------------------------------");
        med.findHighestBidder();

        b2.cancelTheBid();
        System.out.print(b2.name + " Has canceled his bid!, in that case ");

        med.findHighestBidder();
    }
}
