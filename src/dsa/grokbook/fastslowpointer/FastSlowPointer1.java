package dsa.grokbook.fastslowpointer;

/**
 * LinkedList Cycle (easy).
 * Given the head of a Singly LinkedList, write a function
 * to determine if the LinkedList has a cycle in it or not.
 */
public class FastSlowPointer1 {
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = new ListNode1(6);
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    }

    // time is O(N)
    // space is O(1)
    private static boolean hasCycle(ListNode1 head) {
        ListNode1 slow = head;
        ListNode1 fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

class ListNode1 {
    int value = 0;
    ListNode1 next;

    ListNode1(int value) {
        this.value = value;
    }
}
