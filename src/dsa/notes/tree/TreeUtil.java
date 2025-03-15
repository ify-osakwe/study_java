package dsa.notes.tree;

public class TreeUtil<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void inorderBSTree(BSTree<T> node) {
        if (node == null) return;
        inorderBSTree(node.left);
        System.out.print(node.value + " ");
        inorderBSTree(node.right);
    }

    public static <T extends Comparable<T>> void preorderBSTree(BSTree<T> node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorderBSTree(node.left);
        preorderBSTree(node.right);
    }

    public static <T extends Comparable<T>> void postorderBSTree(BSTree<T> node) {
        if (node == null) return;
        postorderBSTree(node.left);
        postorderBSTree(node.right);
        System.out.print(node.value + " ");
    }

    public static <T extends Comparable<T>> int heightBSTree(BSTree<T> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(heightBSTree(node.left), heightBSTree(node.right));
        }
    }

    public static <T extends Comparable<T>> T greatestValueBSTree(BSTree<T> node) {
        if (node.right == null) {
            return node.value;
        } else {
            return greatestValueBSTree(node.right);
        }
    }

    public static <T extends Comparable<T>> BSTree<T> lca(BSTree<T> node, T v1, T v2) {
        if (node == null) {
            return null;
        }

        if (v1.compareTo(node.value) > 0 && v2.compareTo(node.value) > 0) {
            return lca(node.right, v1, v2);
        } else if (v1.compareTo(node.value) < 0 && v2.compareTo(node.value) < 0) {
            return lca(node.left, v1, v2);
        } else {
            return node;
        }
    }

}
