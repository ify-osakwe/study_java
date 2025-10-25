package dsa.ds.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BSTree<T extends Comparable<T>> {

    T value;
    BSTree<T> left;
    BSTree<T> right;

    public BSTree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        if (left == null && right == null) {
            return String.valueOf(value);
        }
        return String.format("%s -> (L:%s, R:%s)", value, left, right);
    }


    public boolean isEmpty() {
        return value == null;
    }

    public void insert(T data) {
        if (isEmpty()) {
            this.value = data;
            return;
        }
        if (data.compareTo(value) < 0) {
            if (left == null) {
                left = new BSTree<>(data);
            } else {
                left.insert(data);
            }
        } else if (data.compareTo(value) > 0) {
            if (right == null) {
                right = new BSTree<>(data);
            } else {
                right.insert(data);
            }
        }
    }

    public BSTree<T> search(T data) {
        if (isEmpty()) return null;

        BSTree<T> node = this;
        while (node != null && !node.value.equals(data)) {
            if (data.compareTo(node.value) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public T searchRecursive(T data) {
        if (value == null || value.equals(data)) {
            return value;
        } else if (data.compareTo(value) < 0) {
            if (left != null) return left.searchRecursive(data);
        } else {
            if (right != null) return right.searchRecursive(data);
        }
        return null;
    }

    public BSTree<T> delete(T data) {
        if (isEmpty()) return null;

        if (data.compareTo(value) < 0) {
            if (left != null) left = left.delete(data);
        } else if (data.compareTo(value) > 0) {
            if (right != null) right = right.delete(data);
        } else {
            if (left == null) return right;
            if (right == null) return left;
            BSTree<T> temp = findMin(right);
            value = temp.value;
            right = right.delete(temp.value);
        }
        return this;
    }

    private BSTree<T> findMin(BSTree<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void bfs() {
        Queue<BSTree<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            BSTree<T> currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
}

