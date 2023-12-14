public class Node<E> {
    private Integer data;
    private Node<Integer> next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(Integer data) {
        this.data = data;
        next = null;
    }

    public Node(Integer data, Node<Integer> next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public Node<Integer> getNext() {
        return next;
    }

    public void setNext(Node<Integer> curr) {
        next = curr;
    }

}