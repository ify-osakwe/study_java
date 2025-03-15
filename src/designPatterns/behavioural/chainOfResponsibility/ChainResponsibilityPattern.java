package designPatterns.behavioural.chainOfResponsibility;

import java.util.Scanner;

class CurrencyD {
    private int amount;

    public CurrencyD(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(CurrencyD currencyD);
}

class Dollar50Dispenser implements DispenseChain {
    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(CurrencyD currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " $50 note");
            if (remainder != 0) {
                this.dispense(new CurrencyD(remainder));
            }
        } else {
            this.dispenseChain.dispense(currency);
        }
    }
}

class Dollar20Dispenser implements DispenseChain {
    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(CurrencyD currency) {
        if (currency.getAmount() >= 20) {
            int num = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing " + num + " $20 note");
            if (remainder != 0) {
                this.dispense(new CurrencyD(remainder));
            }
        } else {
            this.dispenseChain.dispense(currency);
        }
    }
}

class Dollar10Dispenser implements DispenseChain {
    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(CurrencyD currency) {
        if (currency.getAmount() >= 10) {
            int num = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing " + num + " $10 note");
            if (remainder != 0) {
                this.dispense(new CurrencyD(remainder));
            }
        } else {
            this.dispenseChain.dispense(currency);
        }
    }
}

class ChainClient {
    private DispenseChain chain;

    public ChainClient() {
        this.chain = new Dollar50Dispenser();
        DispenseChain chain2 = new Dollar20Dispenser();
        DispenseChain chain3 = new Dollar10Dispenser();
        chain.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }
    public DispenseChain getChain() {
        return chain;
    }
}


/**
 * <p> Examples - try/catch block in Java. java.util.logging.Logger#log().
 * java.servlet.Filter#doFilter()
 */
public class ChainResponsibilityPattern {
    public static void main(String[] args) {
        ChainClient atmDispenser = new ChainClient();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense: ");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiples of 10s");
                return;
            }
            atmDispenser.getChain().dispense(new CurrencyD(amount));
        }
    }
}
