public class Node <E>{
    private E element;
    private Node<E> next;

    Node() {
        element = null;
        next = null;
    }
    Node(E data) {
        element = data;
        next = null;
    }
    Node(E data, Node<E> next){
        element = data;
        this.next = next;
    }
    public E getData() {
        return element;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> curr) {
        next = curr;
    }
}