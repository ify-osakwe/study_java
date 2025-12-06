package dsa.problems.linkedlist;

/**
 * Add two numbers
 * <a href="https://gemini.google.com/share/7c6a4d163990">Gemini Link</a>
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Initialize the dummy head. This simplifies edge cases where the list is empty initially.
        ListNode dummyHead = new ListNode(0);

        // 'current' will track the end of our new result list.
        ListNode current = dummyHead;

        // Variable to store the carry-over from addition (e.g., 5+7=12, carry is 1).
        int carry = 0;

        // Loop as long as there are nodes in l1, l2, OR there is a remaining carry.
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values. If the list has run out (null), use 0.
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate the sum of digits plus the previous carry
            int sum = carry + x + y;

            // Update carry for the NEXT iteration (e.g., 12 / 10 = 1)
            carry = sum / 10;

            // Create the new node with the digit (e.g., 12 % 10 = 2)
            current.next = new ListNode(sum % 10);

            // Move the result pointer forward
            current = current.next;

            // Move the input pointers forward if they are available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return dummyHead.next because dummyHead was just a placeholder.
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Test Case 1: 342 + 465 = 807
        // l1 = [2, 4, 3], l2 = [5, 6, 4]
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});

        System.out.println("Test Case 1:");
        System.out.print("Input: ");
        printList(l1);
        System.out.print(" + ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        printList(result); // Expected: 7 -> 0 -> 8
        System.out.println("-----------------");

        // Test Case 2: 9999999 + 9999 = 10009998
        // Handling different lengths and multiple carries
        ListNode l3 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l4 = createList(new int[]{9, 9, 9, 9});

        System.out.println("Test Case 2 (Uneven lengths + Carries):");
        ListNode result2 = addTwoNumbers(l3, l4);
        System.out.print("Result: ");
        printList(result2);
    }

    // Helper to create a linked list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i : arr) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print the linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
