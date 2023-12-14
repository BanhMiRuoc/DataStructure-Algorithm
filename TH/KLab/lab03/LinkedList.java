public class LinkedList {
    private Node<Integer> head;
    private int num_Nodes;

    public LinkedList() {
        head = null;
        num_Nodes = 0;
    }
    public void addFirst(int item) {
        head = new Node <Integer> (item, head);
        num_Nodes ++;
    }
    public Node<Integer> getHead() {
        return head;
    }
    public int countEven(Node<Integer> head) {
        if(head == null || (head.getNext() == null && head.getData()%2 != 0)) {
            return 0;
        }
        else {
            if(head.getData()%2 == 0) {
                return head.getData() + countEven(head.getNext());
            }
            return countEven(head.getNext());
        }
    }
    public int sumNum(Node<Integer> head) {
        if(head == null)    return 0;
        return head.getData() + sumNum(head.getNext());
    }
}
