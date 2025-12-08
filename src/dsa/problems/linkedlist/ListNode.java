package dsa.problems.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Helper to print list for visualization
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode temp = next;
        while (temp != null) {
            sb.append(" -> ").append(temp.val);
            temp = temp.next;
        }
        return sb.toString();
    }
}
