public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(3, "Three");
        bst.put(1, "One");
        bst.put(4, "Four");
        bst.put(2, "Two");
        bst.put(5, "Five");
        bst.put(7, "Seven");
        bst.put(8, "Eight");
        bst.put(9, "Nine");
        bst.put(2, "Two");
        bst.put(5, "Five");
        System.out.println(bst.get(1));
    }

}