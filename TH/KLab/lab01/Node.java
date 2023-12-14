public class Node <E>{
    private E data;
    private Node <E> next;

    public Node() {
        this(null, null);
    }
    public Node (E data) {
        this.data = data;
        next = null;
    }
    public Node (E data, Node <E> next) {
        this.data = data;
        this.next = next;
    }
    public E getData() {
        return data;
    }
    public Node <E> getNext() {
        return next;
    }
    public void setNext(Node <E> curr) {
        next = curr;
    }
}
