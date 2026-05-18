package dsa.grokbook.fastslowpointer;

/**
 * Middle of the LinkedList (easy).
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 */
public class FastSlowPointer5 {
    public static void main(String[] args) {
        // Input: 1 -> 2 -> 3 -> 4 -> 5 -> null :: Output: 3
        // Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null :: Output: 4
        // Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null :: Output: 4
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        System.out.println("Middle of Node: " + findMiddle(head).value);

        head.next.next.next.next.next = new ListNode1(6);
        System.out.println("Middle of Node: " + findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode1(7);
        System.out.println("Middle of Node: " + findMiddle(head).value);

    }

    // time is O(N)
    // space is O(1)
    private static ListNode1 findMiddle(ListNode1 head) {
        ListNode1 slow = head;
        ListNode1 fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
