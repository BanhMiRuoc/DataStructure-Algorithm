import java.util.NoSuchElementException;

public class MyDoubleLinkedList {
    private DoubleNode<Double> head;
    private int numNode;

    MyDoubleLinkedList() {
        head = null;
        numNode = 0;
    }
    MyDoubleLinkedList(DoubleNode<Double> head, int numNode) {
        this.head = head;
        this.numNode = numNode;
    }
    public void add(double item) {
        if(head == null) {
            head = new DoubleNode<Double> (item);
            numNode++;
        }
        else if (head.getNext() == null) {
            DoubleNode<Double> newNode = new DoubleNode<>(item);
            head.setNext(newNode);
            numNode++;
        }
        else {
            DoubleNode<Double> newNode = new DoubleNode<>(item, head.getNext());
            head.setNext(newNode);
            numNode++;
        }
    }
    public double remove(DoubleNode<Double> node) throws NoSuchElementException {
        if(head == null)    throw new NoSuchElementException("cant remove");
        else {
            if(node.equals(head)) {
                double tmp = head.getData();
                head = head.getNext();
                numNode--;
                return tmp;
            }
            DoubleNode<Double> curr = head, pre = null;
            while (curr.getNext() != null) {
                pre = curr;
                curr = curr.getNext();
                if(curr.equals(node)) {
                    pre.setNext(curr.getNext());
                    numNode--;
                }
            }
            return node.getData();
        }
    }
}
