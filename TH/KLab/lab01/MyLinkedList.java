import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListInterface <E> {
   private Node <E> head;
   private int numNode;
   public MyLinkedList () {
    head = null;
    numNode = 0;
   }
   @Override
    public void addFirst(E item) {
        head = new Node <E> (item, head);
        numNode ++;
    }
    public void addAfter(Node <E> curr, E item) {
        if(curr == null) {
            addFirst(item);
        }
        else {
            Node <E> tmp = new Node <E> (item, curr.getNext());
            curr.setNext(tmp);
            numNode ++;
        }
    }
    public void addLast(E item) {
        if(head == null) {
            addFirst(item);
        }
        else {
            Node <E> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            Node <E> newNode = new Node <E> (item, null);
            tmp.setNext(newNode);
            numNode ++;
        }
    }
    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list.");
        }
        else {
            Node <E> tmp = head;
            head = head.getNext();
            numNode--;
            return tmp.getData();
        }
    }
    public E removeAfter (Node <E> curr) throws NoSuchElementException {
        if (curr == null) {
            throw new NoSuchElementException("Can't remove element from an empty list.");
        }
        else {
            Node <E> tmp = curr.getNext();
            if (tmp != null) {
                curr.setNext(tmp.getNext());
                numNode--;
                return tmp.getData();
            }
            throw new NoSuchElementException("Can't find the next element.");
        }
    }
    public E removeLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list.");
        }
        else {
            if (head.getNext() == null) {
                removeFirst();
            }
            Node <E> tmp = head;
            Node <E> pre = null;
            while (tmp.getNext() != null) {
                pre = tmp;
                tmp = tmp.getNext();
            }
            pre.setNext(tmp.getNext());
            numNode--;
            return tmp.getData();
        }
    }
    public void print() {
        if(head != null) {
            Node <E> tmp = head;
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
    public E getFirst() throws NoSuchElementException {
        if(head == null) {
            throw new NoSuchElementException("Can't show an empty list.");    
        }
        else {
            return head.getData();
        }
    }
    public Node <E> getHead() {
        return head;
    }
    public int size(){
        return numNode;
    }
    public boolean containts (E item) {
        if (head == null)   return false;
        Node <E> tmp = head;
        while (tmp.getNext() != null){
            if(tmp.getData().equals(item))     return true;
            tmp = tmp.getNext();
        }
        return false;
    }
    public E removeCurr(Node <E> curr) throws NoSuchElementException{
        if(curr == null) {
            throw new NoSuchElementException("Can't remove.");
        }
        else {
            if (curr.equals(head)) {
                removeFirst();
            }
            Node <E> pre = null;
            Node <E> tmp = head;
            while(tmp.getNext() != null) {
                pre = tmp;
                tmp = tmp.getNext();
                if(tmp.equals(curr)) {
                    removeAfter(pre);
                }
            }
            return curr.getData();
        }
    }
}
