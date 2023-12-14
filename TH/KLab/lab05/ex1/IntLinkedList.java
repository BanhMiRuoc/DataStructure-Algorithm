public class IntLinkedList {
    private Node head;
    
    public IntLinkedList() {
        head = null;
    }
    public void addFirst(int data) {
        head = new Node(data, head);
    }
    public boolean addLast(int data) {
        if (head == null) {
            head = new Node (data, null);
            return true;
        }
        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(new Node(data, null));
        return true;
    }
    public boolean removeAt(int position){
        if (head == null) {
           return false;
        }
        int countPo = 1;
        Node tmp = head, pre = head;
        if(position == 1 || head.getNext() == null) {
            head = null;
            return true;
        }
        while(tmp.getNext() != null) {
            pre = tmp;
            tmp = tmp.getNext();
            countPo++;
            if(countPo == position) {
                pre.setNext(tmp.getNext());
                return true;
            }
        }
        return false;
    }
    public int countOdd() {
        int cOdd = 0;
        Node tmp = head;
        if (head == null || (head.getNext() == null && head.getData()%2 == 0))   return cOdd;
        if (head.getData()%2 != 0)  cOdd++;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData()%2 != 0)
                cOdd++;
        }
        return cOdd;
        
    }
    public int searchKey(int key){
        if (head == null || (head.getNext() == null && head.getData() != key))
            return -1; 
        int pos = 1;
        if(head.getData() == key)   return pos;
        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            pos++;
            if(tmp.getData() == key)    return pos;
        }
        return -1;
    }
    public boolean checkSorted() {
        boolean check = true;
        if (head == null)   return check;
        Node tmp = head, pre = head;
        while(tmp.getNext()!= null) {
            pre = tmp;
            tmp = tmp.getNext();
            if(tmp.getData() < pre.getData()) {
                return false;
            }
        }
        return check;
    }

}
