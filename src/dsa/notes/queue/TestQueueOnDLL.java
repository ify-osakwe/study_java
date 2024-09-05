package dsa.notes.queue;

public class TestQueueOnDLL {
    public static void main(String[] args) {
        // Create a QueueOnDLL
        QueueOnDLL<Character> queue = new QueueOnDLL<>();

        System.out.println("queue=" + queue);

        //Check if queue is empty
        System.out.println("is queue empty -" + queue.isEmpty());

// Enqueue operation on a Queue

        for (char i = 97; i < 106; i++) {
            queue.enqueue(i);
        }

        System.out.println("queue: " + queue);

        // Peek a Queue
        System.out.println("element in front -" + queue.peek());

        // Size of Queue
        System.out.println("size of queue: " + queue.size());

        // Dequeue operation on a queue
        System.out.println("queue: " + queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println("dequeue twice, queue: " + queue);
        System.out.println("element in front:" + queue.peek());
    }
}
