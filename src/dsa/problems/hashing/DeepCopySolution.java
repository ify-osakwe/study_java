package dsa.problems.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * Deep Copy of a Linked List with Random Pointers
 * <a href="https://gemini.google.com/share/04ea1257e082">Gemini Link</a>
 */
public class DeepCopySolution {

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Map to keep track of created nodes: Key = Original, Value = Copy
        Map<Node, Node> map = new HashMap<>();

        // PASS 1: Create all nodes and store them in the map.
        // We do not wire up the pointers (.next, .random) yet.
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // PASS 2: Connect the pointers.
        // We use the map to translate the original pointers to the new nodes.
        current = head;
        while (current != null) {
            // Get the copy of the current node
            Node copy = map.get(current);

            // Set the copy's next to the copy of the original's next
            copy.next = map.get(current.next);

            // Set the copy's random to the copy of the original's random
            copy.random = map.get(current.random);

            current = current.next;
        }

        // Return the head of the COPIED list
        return map.get(head);
    }

    public static void main(String[] args) {

        // Test Case 1: Head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        // Note: The indices refer to the position in the list (0-indexed)
        System.out.println("--- Test Case 1 ---");
        Node head = createTestList(new Integer[][]{
                {7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}
        });

        System.out.println("Original List:");
        printList(head);

        Node clonedHead = copyRandomList(head);

        System.out.println("\nCloned List:");
        printList(clonedHead);

        System.out.println("\nVerification:");
        System.out.println("Values match? " + verifyValues(head, clonedHead));
        System.out.println("Deep copy (different memory addresses)? " + verifyDeepCopy(head, clonedHead));
    }

    // Helper to construct list from array representation: [[val, random_index], ...]
    private static Node createTestList(Integer[][] data) {
        if (data.length == 0) return null;

        List<Node> nodes = new ArrayList<>();

        // 1. Create all nodes with values
        for (Integer[] pair : data) {
            nodes.add(new Node(pair[0]));
        }

        // 2. Link next and random pointers
        for (int i = 0; i < data.length; i++) {
            // Link next
            if (i < data.length - 1) {
                nodes.get(i).next = nodes.get(i + 1);
            }
            // Link random
            Integer randomIndex = data[i][1];
            if (randomIndex != null) {
                nodes.get(i).random = nodes.get(randomIndex);
            }
        }
        return nodes.get(0);
    }

    // Helper to print list in readable format
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            String randomVal = (curr.random != null) ? String.valueOf(curr.random.val) : "null";
            System.out.print("[" + curr.val + ", random: " + randomVal + "] -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Check if values are identical
    private static boolean verifyValues(Node original, Node copy) {
        while (original != null && copy != null) {
            if (original.val != copy.val) return false;

            int origRand = (original.random == null) ? -1 : original.random.val;
            int copyRand = (copy.random == null) ? -1 : copy.random.val;

            if (origRand != copyRand) return false;

            original = original.next;
            copy = copy.next;
        }
        return original == null && copy == null;
    }

    // Check if nodes are actually different objects in memory
    private static boolean verifyDeepCopy(Node original, Node copy) {
        while (original != null && copy != null) {
            // If the memory address is the same, it's not a deep copy!
            if (original == copy) return false;
            original = original.next;
            copy = copy.next;
        }
        return true;
    }


}
