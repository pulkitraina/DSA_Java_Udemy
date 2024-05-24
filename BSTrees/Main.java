public class Main {
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.root = bst.recInsert(bst.root, 47);
        bst.root = bst.recInsert(bst.root, 21);
        bst.root = bst.recInsert(bst.root, 76);
        bst.root = bst.recInsert(bst.root, 18);
        bst.root = bst.recInsert(bst.root, 27);
        bst.root = bst.recInsert(bst.root, 52);
        bst.root = bst.recInsert(bst.root, 82);

        System.out.println(bst.BFS());
        System.out.println(bst.kthSmallest(2));

        // System.out.println(bst.recContains(bst.root, 64));
        // System.out.println(bst.recContains(bst.root, 45));
    }


}
