public class ex3 {
    public static double a(int n) {
        if (n == 0) return 2;
        return 2 - (1.0/2)*a(n-1);
    }
    public static double c(int n, int k) {
        if (k == 1) return n;
        return n + c(n, k-1);
    }
    public static double b(int n) {
        if (n < 10) return 1;
        return 1 + b(n/10);
    } 
    public static int d(int n) {
        if (n == 0) return 0;
        else if (n == 1)    return 1;
        else {
            return d(n-1) + d(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(d(4));
        //f(4) =  g(3) + g(2)
        //f(3) = g(2) + g(1)
        //f(2) = g(1) + g(0)
        // f2 = 1 => f3 = 2 =>f4 = 2 + 1
    }
}
