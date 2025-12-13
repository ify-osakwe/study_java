package dsa.problems.string;

import dsa.problems.linkedlist.ListNode;

/**
 * Palindrome LinkedList
 * <a href="https://gemini.google.com/share/c7dcb75fd1c5">Gemini Link</a>
 */
public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        // When fast reaches the end, slow will be at the middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        // slow.next is the start of the second half
        ListNode secondHalfHead = reverseList(slow.next);

        // Step 3: Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Step 4 (Optional): Restore the list to maintain original structure
        // This is good practice in interview settings so we don't destroy the input
        slow.next = reverseList(secondHalfHead);

        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Test Case 1: [1, 2, 2, 1] - Palindrome (Even length)
        ListNode head1 = createList(new int[]{1, 2, 2, 1});
        printList("Test 1 Input:", head1);
        boolean res1 = isPalindrome(head1);
        System.out.println("Is Palindrome? " + res1); // Expected: true
        printList("Test 1 After (Verify Restoration):", head1);
        System.out.println("-------------------");

        // Test Case 2: [1, 2] - Not Palindrome
        ListNode head2 = createList(new int[]{1, 2});
        printList("Test 2 Input:", head2);
        boolean res2 = isPalindrome(head2);
        System.out.println("Is Palindrome? " + res2); // Expected: false
        System.out.println("-------------------");

        // Test Case 3: [1, 2, 3, 2, 1] - Palindrome (Odd length)
        ListNode head3 = createList(new int[]{1, 2, 3, 2, 1});
        printList("Test 3 Input:", head3);
        boolean res3 = isPalindrome(head3);
        System.out.println("Is Palindrome? " + res3); // Expected: true
        System.out.println("-------------------");
    }

    // Helper to create a list from an array
    private static ListNode createList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print a list
    private static void printList(String label, ListNode head) {
        System.out.print(label + " ");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
