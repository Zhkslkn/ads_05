public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(10, "ten");
        bst.put(7, "Seven");
        bst.put(11, "Eleven");
        bst.put(12, "Twelve");
        bst.put(16, "Sixteen");
        bst.put(15, "Fifteen");
        bst.put(14, "Fourteen");
        bst.put(20, "Twenty");
        System.out.println(bst.getDeepest());
    }

}