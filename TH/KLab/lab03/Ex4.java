public class Ex4 {
    public static int ex4_a(int n) {
        return (n == 1) ? 3 : 2*n + 1 + ex4_a(n - 1);
    }
    public static int factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n*factorial(n-1);
    }
    public static int sumFac(int n) {
        return (n == 1) ? 1 : factorial(n) + sumFac(n-1);
    }
    public static int productFac(int n) {
        return (n == 1) ? 1 : factorial(n) * productFac(n-1);
    }
    public static int P(int n, int r) {
        return (n >= r && r > 0)  ? n*P(n - 1, r - 1) : 1;
    }
    public static double p(int n) {
        return (n == 1) ? 3 : Math.pow(2, n) + n*n + p(n - 1);
    }
    public static void main(String[] args) {
    //  System.out.println(ex4_a(3));
    //  System.out.println(sumFac(4));
    //  System.out.println(productFac(4));
    //  System.out.println(P(6,3));
    }
}
