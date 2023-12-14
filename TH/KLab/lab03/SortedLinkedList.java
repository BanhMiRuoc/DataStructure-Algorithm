import java.util.NoSuchElementException;

public class SortedLinkedList {
    private Node<Integer> head;
    private int num_Nodes;

    public SortedLinkedList() {
        head = null;
        num_Nodes = 0;
    }

    public SortedLinkedList(Node<Integer> head) {
        this.head = head;
        num_Nodes = 1;
    }
    public Node<Integer> getHead() {
        return head;
    }
    public void print() throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException("Empty list!");
        }
        System.out.print(head.getData());
        Node<Integer> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.print(" -> " + tmp.getData());
        }
        System.out.println();
    }

    public void add(int data) {
        if(head == null || data < head.getData()) {
            head = new Node<>(data, head);
            num_Nodes++;
        } 
        else {
            if(head.getNext() == null) {
                head.setNext(new Node<>(data));
                num_Nodes++;
            }
            else {
                Node<Integer> tmp = head, pre = head;
                while(tmp.getNext() != null) {
                    pre = tmp;
                    tmp = tmp.getNext();
                    if(tmp.getData() < data) {
                        tmp.setNext(new Node<>(data, tmp.getNext()));
                        num_Nodes++;
                        break;
                    }
                    else {
                        pre.setNext(new Node<>(data, tmp));
                        num_Nodes++;
                        break;
                    }
                }
            }
        }
    }
}   
