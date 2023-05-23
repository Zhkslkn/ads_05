import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
    }
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.val;
    }


    private Node get(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node;
    }
    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node temp = node;
                node = min(temp.right);
                node.right = deleteMin(temp.right);
                node.left = temp.left;
            }
        }

        return node;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    private int findDeepest(Node node) {
        int height = 0;
        Node current = node;
        while (current != null) {
            if (current.left == null) {
                current = current.right;
                height++;
            }
            else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else {
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        return height;
    }

    public int getDeepest() {
        return findDeepest(root);
    }

    public V getMin() {
        Node node = min(root);
        return node.val;
    }

    public V getMax() {
        Node node = max(root);
        return node.val;
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }

    private void inOrderTraversal(Node node, List<K> keys) {
        if (node != null) {
            inOrderTraversal(node.left, keys);
            System.out.println(node.key);
            keys.add(node.key);
            inOrderTraversal(node.right, keys);
        }
    }
    public int size() {
        return size;
    }
}
