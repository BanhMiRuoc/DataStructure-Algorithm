import java.util.*;

public class MaxHeap {
    int[] heap;
    int heapSize;
    int maxSize;
    public int heapSize() {
        return heapSize;
    }
    public MaxHeap(int capity) {
        heapSize = 0;
        this.maxSize = capity;
        heap = new int[maxSize + 1];
        heap[0] = -1; //bo heap o index 1
    }
    private int parent(int i) {
        return i/2;
    }
    private int left(int i) {
        return 2*i;
    }
    private int right(int i) {
        return 2*i + 1;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(int key) {
        if(heapSize == maxSize) { 
            throw new NoSuchElementException("Overflow");
        }
        heapSize++;
        heap[heapSize] = key;
        shiftUp(heapSize);
    }
    public void shiftUp(int i) {
        while(i > 1 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public int extractMax() {
        if(heapSize == 0)
            throw new NoSuchElementException("underflow");
        int maxV = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return maxV;
    }
    public void shiftDown(int i) {
        while(i <= heapSize) {
            int maxV = heap[i];
            int maxID = i;
            if(left(i) <= heapSize && maxV < heap[left(i)]) {
                maxV = heap[left(i)];
                maxID = left(i);
            }
            if(right(i) <= heapSize && maxV < heap[right(i)]) {
                maxV = heap[right(i)];
                maxID = right(i);
            }
            if (maxID != i) {
                swap(i, maxID);
                i = maxID;
            }
            else
                break;
        }
    }
    public void print() {
        for(int a: heap) {
            System.out.print(a + " ");
        }
    }
}