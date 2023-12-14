public class Test {
    public static void main(String args[]) {
        AVL a = new AVL();
        a.insert(12);
        a.insert(18);
        a.insert(8);
        a.insert(11);
        a.insert(5);
        a.insert(17);
        a.insert(4);
        a.inOrder();
    }
}
