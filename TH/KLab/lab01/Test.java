public class Test {
    public static void main (String args[]) {
        MyLinkedList<Integer> lst = new MyLinkedList<Integer>();
        IntegerLinkedList l1 = new IntegerLinkedList();
        // lst.addFirst(4);
        // lst.addFirst(2);
        // lst.addFirst(3);
        // lst.addLast(7);
        // lst.print();
        l1.addFirst(1);
        l1.addFirst(5);
        l1.addFirst(7);
        l1.print();
        l1.reverseList();
        l1.print();
        // lst.print();
        // MyLinkedList<Fraction> l1 = new MyLinkedList<Fraction>();
        // l1.addFirst(new Fraction(3, 4));
        // l1.addFirst(new Fraction(5, 4));
        // l1.addFirst(new Fraction(7, 4));
        // l1.print();
        
    }
}
