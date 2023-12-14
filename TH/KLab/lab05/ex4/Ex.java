import java.util.Arrays;
public class Ex {
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int idx = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]) idx = j;
            }
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int len = arr.length;
            boolean flan = false;
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flan = true;
                }
            }
            len--;
            if(!flan)   break;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }
    public static void main(String[] args) {
        int[] arr = {7, 6, 8, 3, 9};
        // selectionSort(arr);
        // bubbleSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
