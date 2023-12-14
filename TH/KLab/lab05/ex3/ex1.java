public class ex1 {
    public static double prod_recur(int a, int b) {
        return (b == 1) ? a : a + prod_recur(a, b-1);
    }
    public static int bin2dec(int n, int exp) {
        if (n == 0)  return 0;
        else {
            int digit = n%10;
            return digit * (int) Math.pow(2, exp) + bin2dec(n/10, exp + 1);
        }
    }
    public static int maxDigit(int n) {
        if (n > 0) {
            int max = n%10;
            return (max > maxDigit(n/10)) ? max : maxDigit(n/10);
        }
        return n;
    }
    public static int maxElement(int a[], int n) {
        if (n > 0) {
            int max = a[n-1];
            return (max > maxElement(a, n-1)) ? max : maxElement(a, n-1);
        }
        return a[0];
    }
    public static int search (int a[], int n, int key) {
        if (n > 0) {
            int s = a[n-1];
            return (key == s) ? (n-1) : search(a, n-1, key) ;
        }
        return -1;
    }
    public static int findLastEvenPosition(int a[], int n) {
        if (n > 0) {
            int even = a[n-1];
            return (even%2 == 0) ? even : findLastEvenPosition(a, n-1);
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(prod_recur(3, 3));
        System.out.println(bin2dec(1111, 0));
        System.out.println(maxDigit(124386));
        int[] a = {3, 1, 7, 5, 2};
        System.out.println(maxElement(a, a.length));
        System.out.println(search(a, a.length, 1));
        System.out.println(findLastEvenPosition(a, a.length));
    }
    
}