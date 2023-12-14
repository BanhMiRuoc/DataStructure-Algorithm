import java.util.Arrays;
public class Ex1 {
    public static void selectionSort(int a[]) {
        for(int i = 0; i < a.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[min])   min = j;
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
    public static void bubbleSort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }   
    public static void insertionSort(int[] a) {
            for(int i = 1; i < a.length; i++) {
                int key = a[i];
                int j = i - 1;
                while(j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                    a[j + 1] = key;
                }
            }
    }
    public static void merge(int[] a, int first, int mid, int last) {
        int[] tmp = new int[last - first +1];
        int left = first, right = mid + 1, it = 0;
        while(left <= mid && right <=last) {
            if(a[left] <= a[right]) {
                tmp[it++] = a[left++];
            }
            else
                tmp[it++] = a[right++];
        }
        while (left<=mid) tmp[it++] = a[left++];
	    while (right<=last)  tmp[it++] = a[right++];
        for (int k = 0; k < tmp.length; k++) 
		a[first+k] = tmp[k];

    }
    public static void mergeSort(int[] a,int first, int last) {
        if(first < last) {
            int mid = (first + last)/2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
        }
    }
    public static void quickSort(int[] a, int i, int j) {
        if(i < j) {
            int pivotIdx = partition(a, i, j);
            quickSort(a, i, pivotIdx-1);
		    quickSort(a, pivotIdx+1, j);	
        }
    }
    public static int partition(int[] a, int i, int j) {
        int p = a[i];
        int m = i;	
        for (int k=i+1; k<=j; k++) { 
            if (a[k] < p) { 
                m++;
                swap(a,k,m);
            } 
        }
        swap(a,i,m); 
        return m;  
    }
    public static void swap(int a[], int i, int j) {
        int tmp= a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 1, 6, 0};
        System.out.println(Arrays.toString(a));
        // selectionSort(a);
        // bubbleSort(a);
        // insertionSort(a);
        // mergeSort(a, 0, 5);
        quickSort(a, 0, 5);
        System.out.println(Arrays.toString(a));

    }
}