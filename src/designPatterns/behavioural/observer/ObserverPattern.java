package designPatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

interface ObserverF {
    void update();

    void setSubject(SubjectF subject);
}

class MyTopicSubscriber implements ObserverF {
    private String name;
    private SubjectF topic;

    public MyTopicSubscriber(String string) {
        this.name = string;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate(this);
        if (message == null) {
            System.out.println(name + " :: No new message");
        } else {
            System.out.println(name + " :: Consuming message::" + message);
        }
    }

    @Override
    public void setSubject(SubjectF subject) {
        this.topic = subject;
    }
}

interface SubjectF {
    void register(ObserverF observer);

    void unregister(ObserverF observer);

    void notifyObservers();

    Object getUpdate(ObserverF observer);

}


class MyTopic implements SubjectF {
    private List<ObserverF> observers;
    private String message;
    private boolean changed;

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(ObserverF observer) {
        if (observer == null) {
            throw new NullPointerException("Null observer");
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(ObserverF observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<ObserverF> observerLocal;
        if (!changed) return;

        observerLocal = new ArrayList<>(this.observers);
        this.changed = false;

        for (ObserverF observer : observerLocal) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(ObserverF observer) {
        return this.message;
    }

    public void postMessage(String message) {
        System.out.println("Message posted to topic " + message);
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}

/**
 * <p> The observer pattern defines a one-to-many relationship between a set of objects.
 * When the state of one object changes, all of its dependents are notified.
 *
 * <p> Examples in JDK = java.util (Observer & Observable)
 */
public class ObserverPattern {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();
        ObserverF observer1 = new MyTopicSubscriber("Obj1");
        ObserverF observer2 = new MyTopicSubscriber("Obj2");
        ObserverF observer3 = new MyTopicSubscriber("Obj3");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        observer1.update();
        topic.postMessage("New message");
    }
}
