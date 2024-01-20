package designPatterns.behavioural.iterator;

class NotificationG {
    String notification;

    public NotificationG(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }
}

interface CollectionG {
    IteratorG createIterator();
}

interface IteratorG {
    boolean hasNext();

    Object next();
}

class NotificationCollection implements CollectionG {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    NotificationG[] notificationList;

    @Override
    public IteratorG createIterator() {
        return new NotificationIterator(notificationList);
    }

    public NotificationCollection() {
        notificationList = new NotificationG[MAX_ITEMS];
        addItem("Notification 1");
        addItem("Notification 2");
        addItem("Notification 3");

    }

    public void addItem(String string) {
        NotificationG notification = new NotificationG(string);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Full");
        } else {
            notificationList[numberOfItems] = notification;
            numberOfItems += 1;
        }
    }
}

class NotificationIterator implements IteratorG {
    NotificationG[] notificationList;
    int position = 0;

    public NotificationIterator(NotificationG[] notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public boolean hasNext() {
        if (position >= notificationList.length || notificationList[position] == null) {
            return false;
        } else {
            return true;
        }
        // return position < notificationList.length && notificationList[position] != null;
    }

    @Override
    public Object next() {
        NotificationG notification = notificationList[position];
        position += 1;
        return notification;
    }
}

class NotificationBar {
    NotificationCollection notifications;

    public NotificationBar(NotificationCollection notifications) {
        this.notifications = notifications;
    }

    public void printNotifications() {
        IteratorG iterator = notifications.createIterator();
        System.out.println("-------- NOTIFICATION BAR --------");
        while (iterator.hasNext()) {
            NotificationG notification = (NotificationG) iterator.next();
            System.out.println(notification.getNotification());
        }
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        NotificationCollection notificationCollection = new NotificationCollection();
        NotificationBar notificationBar = new NotificationBar(notificationCollection);
        notificationBar.printNotifications();
    }
}
