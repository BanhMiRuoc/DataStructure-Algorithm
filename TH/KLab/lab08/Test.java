public class Test {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(17);
        MaxHeap m = new MaxHeap(17);
        h.insert(15);
        h.insert(23);
        h.insert(18);
        h.insert(63);
        h.insert(21);
        h.insert(35);
        h.insert(36);
        h.insert(21); 
        h.insert(66);
        h.insert(12);
        h.insert(42);
        h.insert(35);
        h.insert(75);
        h.insert(23);
        h.insert(64);
        h.insert(78);
        h.insert(39);
        m.insert(15);
        m.insert(23);
        m.insert(18);
        m.insert(63);
        m.insert(21);
        m.insert(35);
        m.insert(36);
        m.insert(21); 
        m.insert(66);
        m.insert(12);
        m.insert(42);
        m.insert(35);
        m.insert(75);
        m.insert(23);
        m.insert(64);
        m.insert(78);
        m.insert(39);
        // h.print();
        Assort(h);
        System.out.println();
        Dessort(m);
    }
    public static void Assort(MinHeap h) {
        while(h.heapSize() > 0)
            System.out.print(h.extractMax() + " ");
    }
    public static void Dessort(MaxHeap h) {
        while(h.heapSize() > 0)
            System.out.print(h.extractMax() + " ");
    }
}