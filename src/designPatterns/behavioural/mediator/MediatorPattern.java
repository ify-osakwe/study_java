package designPatterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String message, UserP user);

    void addUser(UserP user);
}

class ChatMediatorImpl implements ChatMediator {
    private List<UserP> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, UserP user) {
        for (UserP usr : this.users) {
            if (usr != user) {
                usr.receive(message);
            }
        }
    }

    @Override
    public void addUser(UserP user) {
        this.users.add(user);
    }
}

abstract class UserP {
    protected ChatMediator chatMediator;
    protected String name;

    public UserP(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}

class UserImpl extends UserP {

    public UserImpl(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sending message = " + message);
        chatMediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " received message = " + message);
    }
}

/**
 * <p> Examples in JDK: java.util.Timer#schedule methods. Java Concurrency Executor execute method.
 * java.lang.reflect.Method#invoke method. Java Message Service uses mediator pattern along with Observer
 * pattern to allow applications to subscribe and publish data to other applications
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        UserP user1 = new UserImpl(mediator, "Bunmi");
        UserP user2 = new UserImpl(mediator, "Funmi");
        UserP user3 = new UserImpl(mediator, "Wunmi");
        UserP user4 = new UserImpl(mediator, "Kemi");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hello allx");

    }
}
