public class ex2 {
    public static int a(int n) {
        if (n == 1) return 2;
        return (int)Math.pow(2, n) + a(n-1);
    }
    public static double b(int n) {
        if (n == 0) return 0.5;
        return (double)(n + 1.0)/2.0 + b(n-1); 
    }
    public static double c(int n) {
        if (n == 1) return 1;
        return fac(n)/ fac(n - 1) + c(n-1);
    }
    public static double fac(int n) {
        if(n == 0)  return 1;
        return n*fac(n-1);
    }
    public static int d(int n) {
        if (n == 1) return 0;
        return n*(n-1) + d(n-1);
    }
    public static int e(int n) {
        if (n == 1) return n;
        return n*e(n-1);
    }
    public static void main(String[] args) {
        // System.out.println(a(4));
        // System.out.println(b(2));
        System.out.println(c(3));


    }
}
