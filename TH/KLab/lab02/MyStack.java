import java.util.NoSuchElementException;

public class MyStack <E> implements StackInteface <E>{
    private Node<E> top;
    private int numNode;

    public MyStack(){
        top = null;
        numNode = 0;
    }
    public MyStack(Node<E> top, int numNode) {
        this.top = top;
        this.numNode = numNode;
    }
    public void push(E item) {
        if(top == null) {
            top = new Node<E>(item);
            numNode++;
        }
        else {
            Node<E> preTop = top;
            top = new Node<E>(item, preTop);
            numNode++;
        }
    }
    public E pop() {
        Node<E> tmp = top;
        top = top.getNext();
        numNode--;
        return tmp.getData();
    }
    public int size() {
        return numNode;
    }
    public boolean contains (E item) {
        if (top == null)   return false;
        Node <E> tmp = top;
        while (tmp.getNext() != null){
            if(tmp.getData().equals(item))     return true;
            tmp = tmp.getNext();
        }
        return false;
    }
    public void print() {
        if(top != null) {
            Node <E> tmp = top;
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
    public E getPeek() throws NoSuchElementException{
        if (top == null) {
            throw new NoSuchElementException("Empty Stack!!!");
        }
        return top.getData();
    }
}
