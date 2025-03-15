package dsa.notes.tree;

import timBuchalka.UtilsX;

public class TestBSTree {
    public static void main(String[] args) {
        // Initializing arrays
        Integer[] a1 = {8, 3, 6, 1, 10, 14, 13, 4, 7};
        Integer[] a2 = {10, 20, 8, 12, 17, 25, 19};

        // Creating and inserting into the first BST
        BSTree<Integer> bst = new BSTree<>(8);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);
        bst.insert(4);
        bst.insert(7);

        // Creating and inserting into the second BST
        BSTree<Integer> bst2 = new BSTree<>(15);
        for (Integer number : a2) {
            bst2.insert(number);
        }

        // Printing the BSTs
        System.out.println("BST-1: " + bst);
        System.out.println("BST-2: " + bst2 + "\n");


        // breadth first search
        System.out.print("BST-1 bfs: ");
        bst.bfs();
        System.out.print("BST-2 bfs: ");
        bst2.bfs();
        UtilsX.newLineSpace();

        // Searching in a BST
        System.out.println("search 5 in BST-1: " + bst.search(5));
        System.out.println("search 10 in BST-1: " + bst.search(10));
        System.out.println("search 9 in BST-2: " + bst.search(9));
        System.out.println("search 17 in BST-2: " + bst.search(17));
        UtilsX.newLineSpace();

        // Searching recursively in a BST
        System.out.println("search 5 in BST-1: " + bst.searchRecursive(5));
        System.out.println("search 10 in BST-1: " + bst.searchRecursive(10));
        System.out.println("search 9 in BST-2: " + bst.searchRecursive(9));
        System.out.println("search 17 in BST-2: " + bst.searchRecursive(17));
        UtilsX.newLineSpace();

        // In-order, Post-order, Pre-order traversal
        System.out.print("In-order traversal: ");
        TreeUtil.inorderBSTree(bst2);
        System.out.print("Pre-order traversal: ");
        TreeUtil.preorderBSTree(bst2);
        System.out.print("Post-order traversal: ");
        TreeUtil.postorderBSTree(bst2);
        UtilsX.newLineSpace();

        //
        System.out.println("Height of BST-2: " + TreeUtil.heightBSTree(bst2));
        System.out.println("Greatest value of BST-2: " + TreeUtil.greatestValueBSTree(bst2));
        UtilsX.newLineSpace();

        // deletion in a BSTree
        BSTree<Integer> bst3 = new BSTree<>(15);
        bst3.insert(10);
        bst3.insert(8);
        bst3.insert(12);
        bst3.insert(20);
        bst3.insert(17);
        bst3.insert(25);
        bst3.insert(19);
        System.out.println("BST-3: " + bst3);
        System.out.print("BST-3 bfs: " + "\n");
        bst3.bfs();
        /*
         * # # remove node with value 8
         * # bst3.delete(8)
         * # print('nodes after removing 8')
         * # bst3.bfs()
         * # print('\n')
         * #
         * # # remove node with value 17
         * # bst3.delete(17)
         * # print('nodes after removing 17')
         * # bst3.bfs()
         * # print('\n')
         * #
         * # # remove node with value 15
         * # bst3.delete(15)
         * # print('nodes after removing 15')
         * # bst3.bfs()
         * # print('\n')
         */

    }
}
