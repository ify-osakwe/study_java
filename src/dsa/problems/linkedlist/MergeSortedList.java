package dsa.problems.linkedlist;

/**
 * Merge Sorted Linked List
 * <a href="https://gemini.google.com/share/6815f1fc451a">Gemini Link</a>
 */
public class MergeSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node to simplify edge cases (like empty lists).
        // The value -1 is arbitrary and won't be in the final result.
        ListNode dummy = new ListNode(-1);

        // 'current' will track the last node in our new merged list.
        ListNode current = dummy;

        // 2. Loop until we reach the end of ONE of the lists.
        while (list1 != null && list2 != null) {

            // Compare values of the two heads
            if (list1.val <= list2.val) {
                current.next = list1;   // Attach list1 node to our new list
                list1 = list1.next;     // Move list1 pointer forward
            } else {
                current.next = list2;   // Attach list2 node to our new list
                list2 = list2.next;     // Move list2 pointer forward
            }

            // Move our builder pointer forward
            current = current.next;
        }

        // 3. One of the lists is now empty.
        // Since the lists are sorted, we just attach the remainder of the
        // non-empty list to the end of our new list.
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // 4. Return dummy.next (skipping the fake -1 node we created at the start)
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        ListNode l1 = createList(new int[]{1, 2, 4});
        ListNode l2 = createList(new int[]{1, 3, 4});
        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        ListNode result1 = mergeTwoLists(l1, l2);
        System.out.print("Merged: ");
        printList(result1);

        System.out.println("\n--- Test Case 2 (Empty Lists) ---");
        ListNode l3 = createList(new int[]{});
        ListNode l4 = createList(new int[]{});
        System.out.print("List 1: ");
        printList(l3);
        System.out.print("List 2: ");
        printList(l4);

        ListNode result2 = mergeTwoLists(l3, l4);
        System.out.print("Merged: ");
        printList(result2);

        System.out.println("\n--- Test Case 3 (One Empty) ---");
        ListNode l5 = createList(new int[]{});
        ListNode l6 = createList(new int[]{0});
        System.out.print("List 1: ");
        printList(l5);
        System.out.print("List 2: ");
        printList(l6);

        ListNode result3 = mergeTwoLists(l5, l6);
        System.out.print("Merged: ");
        printList(result3);
    }

    // Helper to print a linked list: 1 -> 2 -> 4 -> null
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

    // Helper to create a list from an array of integers
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
