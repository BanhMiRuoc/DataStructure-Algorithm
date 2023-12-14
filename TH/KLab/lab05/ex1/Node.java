public class Node {
    private int data;
    private Node next;
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node() {
        data = 0;
        next = null;
    }
    public int getData() {
        return data;
    }
    public void setNext(Node node) {
        next = node;
    }
    public Node getNext() {
        return next;
    }
}
