package dsa.problems.linkedlist;

/**
 * Detect cycle in LinkedList
 * <a href="https://gemini.google.com/share/283086ce78f2">Gemini Link</a>
 */
public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Floyd's Cycle-Finding Algorithm OR "Tortoise and Hare" algorithm.
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Loop as long as the fast runner has a path forward
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer 1 step
            fast = fast.next.next;    // Move fast pointer 2 steps

            // If the two pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If we reach here, the fast pointer reached the end (null)
        // Therefore, there is no cycle.
        return false;
    }


    public static void main(String[] args) {
        // TEST CASE 1: Head = [3,2,0,-4], pos = 1 (Cycle connects to index 1)
        System.out.println("--- Test Case 1 ---");
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        // Link them: 3 -> 2 -> 0 -> -4
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Create Cycle: -4 points back to 2 (index 1)
        n4.next = n2;

        boolean result1 = hasCycle(n1);
        System.out.println("Expected: true");
        System.out.println("Actual:   " + result1);
        System.out.println();


        // TEST CASE 2: Head = [1,2], pos = 0 (Cycle connects to index 0)
        System.out.println("--- Test Case 2 ---");
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);

        // Link them: 1 -> 2
        m1.next = m2;

        // Create Cycle: 2 points back to 1 (index 0)
        m2.next = m1;

        boolean result2 = hasCycle(m1);
        System.out.println("Expected: true");
        System.out.println("Actual:   " + result2);
        System.out.println();


        // TEST CASE 3: Head = [1], pos = -1 (No Cycle)
        System.out.println("--- Test Case 3 ---");
        ListNode k1 = new ListNode(1);
        // k1.next remains null

        boolean result3 = hasCycle(k1);
        System.out.println("Expected: false");
        System.out.println("Actual:   " + result3);
    }
}
