package designPatterns.behavioural.chainOfResponsibility;

enum MessagePriority {
    Normal, High
}

class Message {
    public String text;
    public MessagePriority priority;

    public Message(String msg, MessagePriority p){
        text = msg;
        priority = p;
    }
}

class IssueRaiser {
    public ReceiverInterface firstReceiver;

    public IssueRaiser(ReceiverInterface firstReceiver) {
        this.firstReceiver = firstReceiver;
    }

    public void raiseMessage(Message message) {
        if (firstReceiver != null) {
            firstReceiver.processMessage(message);
        }
    }
}

public class ChainResponsibilityPattern2 {
    public static void main(String[] args) {
        System.out.println("***Chain of Responsibility Pattern Demo***\n");

        // making the chain first:  Fax -> email
        ReceiverInterface faxHandler, emailHandler;

        // end of chain
        emailHandler = new EmailErrorHandler();

        // fax handler is before email
        faxHandler = new FaxErrorHandler();
        faxHandler.setNextChain(emailHandler);

        // starting point: raiser will raise issues and set the first handler
        IssueRaiser raiser = new IssueRaiser(faxHandler);

        Message m1 = new Message("Fax is reaching late to the destination", MessagePriority.Normal);
        Message m2 = new Message("Email is not going", MessagePriority.High);
        Message m3 = new Message("In Email, BCC field is disabled occasionally", MessagePriority.Normal);
        Message m4 = new Message("Fax is not reaching destination", MessagePriority.High);

        raiser.raiseMessage(m1);
        raiser.raiseMessage(m2);
        raiser.raiseMessage(m3);
        raiser.raiseMessage(m4);
    }
}
