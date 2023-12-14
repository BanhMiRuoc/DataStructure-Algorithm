public class Test {
    public static void main(String[] args) {
        CharLinkedList c = new CharLinkedList();
        c.addFirst('a');
        c.addFirst('z');
        c.addFirst('A');
        c.addFirst('c');
        c.addFirst('b');
        c.addFirst('Y');
        c.print();
        System.out.println(c.largestCharPostition());
        c.addAfterFirstKey('r', 'c');
        c.print();
    }
}
