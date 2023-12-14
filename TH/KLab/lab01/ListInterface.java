interface ListInterface <E>{
    public void addFirst(E item);
    public void addAfter(Node <E> curr, E item);
    public void addLast(E item);
    public E removeFirst();
    public E removeAfter(Node <E> curr);
    public E removeLast();
    public int size();
    public boolean containts(E item);
    public void print();
    public boolean isEmpty();
    public Node <E> getHead();
    public E getFirst();
}
