package dsa.problems.linkedlist;

/**
 * Flatten tree
 * <a href="https://gemini.google.com/share/79bc603e3150">Gemini Link</a>
 */
public class FlattenTree {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {
            // We only need to perform logic if there is a left child to process
            if (curr.left != null) {

                // Step 1: Find the rightmost node of the left subtree.
                // This node is the "predecessor" of the current right child 
                // in the pre-order sequence.
                TreeNode runner = curr.left;
                while (runner.right != null) {
                    runner = runner.right;
                }

                // Step 2: Rewire the connections
                // Connect the rightmost node of the left subtree to the current right child
                runner.right = curr.right;

                // Move the left subtree to be the right child
                curr.right = curr.left;

                // Ensure the left child is null (as per problem constraints)
                curr.left = null;
            }

            // Move to the next node (which is always to the right now)
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        // Example 1 Construction: root = [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println("--- Example 1 ---");
        System.out.println("Flattening tree...");
        flatten(root);
        printFlattenedTree(root);
        // Expected: [1, null, 2, null, 3, null, 4, null, 5, null, 6]

        // Example 2: Empty Tree
        TreeNode root2 = null;
        System.out.println("\n--- Example 2 (Empty) ---");
        flatten(root2);
        printFlattenedTree(root2);
        // Expected: []

        // Example 3: Single Node
        TreeNode root3 = new TreeNode(0);
        System.out.println("\n--- Example 3 (Single Node) ---");
        flatten(root3);
        printFlattenedTree(root3);
        // Expected: [0]
    }

    // Helper to print the flattened tree
    public static void printFlattenedTree(TreeNode node) {
        System.out.print("Output: [");
        while (node != null) {
            System.out.print(node.val);
            if (node.right != null) System.out.print(", null, ");
            node = node.right;
        }
        System.out.println("]");
    }
}
