import java.util.NoSuchElementException;

public class IntegerLinkedList {
    private Node <Integer> head;
    private int numNode;

    public IntegerLinkedList() {
        head = null;
        numNode = 0;
    }
    public IntegerLinkedList(Node<Integer>head, int numNode) {
        this.head = head;
        this.numNode = numNode;
    }
    public void addFirst(int item) {
        head = new Node <Integer> (item, head);
        numNode ++;
    }
    public int EvenCount() {
        if(head == null) {
            return 0;
        }
        else {
            int count = 0;
            if(head.getData() %2 == 0) {
                count ++;
            }
            Node <Integer> tmp = head;
            while(tmp.getNext() != null) {
                if(tmp.getNext().getData() %2 == 0) {
                    count ++;
                }
                tmp = tmp.getNext();
            }
            return count;
        }
    }
    public boolean findPrime(Node <Integer> node) {
        if(node.getData() < 2)  return false;
        if(node.getData() == 2) return true;
        else {
            for(int i = 3; i < node.getData(); i++) {
                if(node.getData() %i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public int CountPrime() {
        if(head == null)    return 0;
        else {
            Node <Integer> tmp = head;
            int count = 0;
            if(findPrime(head)) {
                count++;
            }
            while(tmp.getNext() != null) {
                if(findPrime(tmp.getNext()))
                    count++;
                tmp = tmp.getNext();
            }
            return count;
        }
    }
    public void findFirstEven(int X) throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException("Empty list!");
        }
        else {
            if(head.getData() %2 == 0) {
                Node <Integer> newNode = new Node<Integer>(X, head);
                head = newNode;
                numNode++;
            }
            Node <Integer> tmp = head;
            Node <Integer> pre = null;
            while (tmp.getNext() != null) {
                pre = tmp;
                tmp = tmp.getNext();
                if (tmp.getNext().getData() %2 == 0) {
                    Node <Integer> newNode = new Node<Integer>(X, tmp);
                    pre.setNext(newNode);
                    numNode++;
                }
            }
        }
    }
    public void print() {
        if(head != null) {
            Node <Integer> tmp = head;
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
    public int findMax() throws NoSuchElementException{
        if(head == null) {
            throw new NoSuchElementException("Empty List!");
        }
        else {
            int max = head.getData();
            Node <Integer> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                if(max < tmp.getData()) {
                    max = tmp.getData();
                }
            }
            return max;
        }
    }
    public void reverseList() throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException("Empty List!");
        }
        else {
            Node <Integer> pre = null, curr = head, next = null;
            while (curr.getNext() != null) {
                next = curr.getNext();
                curr.setNext(pre);
                pre = curr;
                curr = next;
            }
        }
    }
    public void ascending() throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException("Empty List!");
        }
        else {
            Node<Integer> min = head, cur = head, tmp = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
                tmp = cur;
                if (min.getData() > tmp.getData()) {
                    min = tmp;
                    cur = min;
                }
            }
        }
    }
}
