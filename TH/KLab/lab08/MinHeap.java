import java.util.*;

public class MinHeap {
    int[] heap;
    int heapSize;
    int maxSize;
    public int heapSize() {
        return heapSize;
    }
    public MinHeap(int capity) {
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
        while(i > 1 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public int extractMax() {
        if(heapSize == 0)
            throw new NoSuchElementException("underflow");
        int minV = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return minV;
    }
    public void shiftDown(int i) {
        while(i <= heapSize) {
            int minV = heap[i];
            int minID = i;
            if(left(i) <= heapSize && minV > heap[left(i)]) {
                minV = heap[left(i)];
                minID = left(i);
            }
            if(right(i) <= heapSize && minV > heap[right(i)]) {
                minV = heap[right(i)];
                minID = right(i);
            }
            if (minID != i) {
                swap(i, minID);
                i = minID;
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