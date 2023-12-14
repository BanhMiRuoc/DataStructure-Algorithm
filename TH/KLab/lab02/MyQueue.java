import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueInteface<E> {
    private Node<E> front;
    private Node<E> rear;
    private int numNode;

    public MyQueue() {
        front = rear = null;
        numNode = 0;
    }
    public MyQueue(Node<E> front, Node<E> rear, int numNode) {
        this.front = front;
        this.rear = rear;
        this.numNode = numNode;
    }
    public void enQueue(E item) {
        if (rear == null) {
            rear = new Node<E>(item);
            if(front == null) {
                front = rear;
            }
            numNode++;
        }
        else {
            Node<E> preRear = rear, tmp1 = null, tmp2 = rear;
            rear = new Node<E>(item, preRear);
            numNode++;
            if(front == null) {
                while(tmp2.getNext() != null) {
                    tmp1 = tmp2;
                    tmp2 = tmp2.getNext();
                }
                front = tmp1;
            }
        }

    }
    public E deQueue() throws NoSuchElementException{
        if(front == null && rear == null) {
            throw new NoSuchElementException("Empty Queue");
        }
        else {
            Node<E> newFront = rear, tmp = front;
            while(newFront.getNext() != front) {
                newFront = newFront.getNext();
            }
            newFront.setNext(null);
            front = newFront;
            numNode--;
            return tmp.getData();
        }
    }
    public int size() {
        return numNode;
    }
    public boolean contains (E item) {
        if (rear == null)   return false;
        Node <E> tmp = rear;
        while (tmp.getNext() != null){
            if(tmp.getData().equals(item))     return true;
            tmp = tmp.getNext();
        }
        return false;
    }
    public void print() {
        if(rear != null) {
            Node <E> tmp = rear;
            System.out.print("List: " + tmp.getData());
            tmp = tmp.getNext();
            while(tmp != null) {
                System.out.print(", " + tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        }
        else {
            System.out.println("The Empty list.");
        }
    }
    public boolean isEmpty() {
        if(numNode == 0) return true;
        return false;
    }
    public E getFront() throws NoSuchElementException{
        if (front == null) {
            throw new NoSuchElementException("Empty Stack!!!");
        }
        return front.getData();
    }
}
