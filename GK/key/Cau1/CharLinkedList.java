public class CharLinkedList implements ListInterface{
    private Node head;
    public CharLinkedList() {
        head = null;
    }
    public CharLinkedList(Node head) {
        this.head = head;
    }
    public Node getHead() {
        return head;
    }
    public void addFirst(char data) {
        head = new Node(data, head);
    }
    public boolean addAfterFirstKey(char data, char key) {
        if (head == null)   return false;
        if(key == head.getData()) {
            head.setNext(new Node(data, head.getNext()));
            return true;
        }
        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData() == key) {
                tmp.setNext(new Node(data, tmp.getNext()));
                return true;
            }
        }
        return false;
    }
    public int largestCharPostition() {
        int pos = 0, posMax = 0;
        if (head == null)   return -1;
        if(head.getNext() == null)  return posMax;
        Node tmp = head, max = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            pos++;
            if(tmp.getData() > max.getData()) {
                max = tmp;
                posMax = pos;
            }
        }
        return posMax;
    }
    public void print() {
        if (head == null)   System.out.println("empty");
        Node tmp = head;
        System.out.print(head.getData());
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.print(", " + tmp.getData());
        }
        System.out.println("\n");
    }

}
