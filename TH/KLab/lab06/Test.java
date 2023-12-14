public class Test {
    public static void main(String[] args) {
        BST bi = new BST(new Node(1));
        // BST bi = new BST();
        // bi.insert(3);
        // bi.insert(4);
        // bi.insert(7);
        // bi.insert(6);
        // bi.insert(15);
        // bi.insert(9);
        // bi.insert(16);
        // bi.insert(1);
        // bi.lnr();
        // System.out.println("\n");
        // bi.nlr();
        // System.out.println("\n");
        // bi.delete(15);
        // System.out.println(bi.search(15));
        // System.out.println(bi.min());
        // System.out.println(bi.max());
        // System.out.println(bi.contains(55));
        // bi.delete_pre(7);
        // bi.lnr();
        // System.out.println("\n");
        // bi.nlr();
        // System.out.println(bi.sumEven());
        // System.out.println(bi.countLeaves());
        // System.out.println(bi.sumEvenKeyAtLeaves());
        bi.insert(2);
        bi.insert(3);
        bi.insert(4);
        bi.insert(5);
        bi.bfs();
    }
}
