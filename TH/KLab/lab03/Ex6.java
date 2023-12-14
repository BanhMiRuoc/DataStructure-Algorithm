public class Ex6 {
    public static int findMin(int[] arr, int size) {
        int min = arr[0];
        for(int i = 1; i < size; i++) {
            if(min > arr[i])    min = arr[i];
        }
        return min;
    }
    public static int sumElements(int[] arr, int size) {
        int rs = 0;
        for(int i = 0; i < size; i++) {
            rs += arr[i];
        }
        return rs;
    }
    public static int countEven(int[] arr, int size) {
        int count = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i]%2 == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int a[] = {2, 3, 5, -1, 6};
        System.out.println(findMin(a, a.length));
        System.out.println(sumElements(a, a.length));
    }
}
