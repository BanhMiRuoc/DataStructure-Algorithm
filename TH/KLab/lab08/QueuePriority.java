import java.util.NoSuchElementException;

public class QueuePriority {
    Person[] heap;
    int heapSize;
    int maxSize;

    public QueuePriority(int capity) {
        heapSize = 0;
        this.maxSize = capity;
        heap = new Person[maxSize + 1];
        heap[0] = new Person("###", -1);
    }

    private int parent(int i) {
        return i/2;
    }

    private int left(int i) {
        return i*2;
    }

    private int right(int i) {
        return i*2 + 1;
    }

    private void swap(int i, int j) {
        Person temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void shiftUp(int i) {
        while(i > 1 && heap[parent(i)].getPriority() < heap[i].getPriority()) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    
    public void enqueue(Person key) {
        if(heapSize == maxSize) {
            throw new NoSuchElementException("Overflow Exception");
        } 
        heapSize++;
        heap[heapSize] = key;
        shiftUp(heapSize);
    }

    private void shiftDown(int i) {
        int indexMax, max;
        while(i <= heapSize) {
            indexMax = i;
            max = heap[i].getPriority();
            if(left(i) <= heapSize && heap[left(i)].getPriority() > max) {
                max = heap[left(i)].getPriority();
                indexMax = left(i);
            }
            if(right(i) <= heapSize && heap[right(i)].getPriority() > max) {
                max = heap[right(i)].getPriority();
                indexMax = right(i);
            }
            if(indexMax != i) {
                swap(indexMax, i);
                i = indexMax;
            } else {
                break;
            }
        }
    }

    public Person dequeue() {
        Person max = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return max;
    }

    public static void main(String[] args) {
        QueuePriority queue = new QueuePriority(10);

        queue.enqueue(new Person("Alex", 3));
        queue.enqueue(new Person("Bob", 2));
        queue.enqueue(new Person("David", 6));
        queue.enqueue(new Person("Susan", 1));

        System.out.println(queue.dequeue());

        queue.enqueue(new Person("Mike", 5));
        queue.enqueue(new Person("Kevin", 4));

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(new Person("Helen", 0));
        queue.enqueue(new Person("Paul", 8));
        queue.enqueue(new Person("Iris", 7));

        System.out.println(queue.dequeue());
    }
}
