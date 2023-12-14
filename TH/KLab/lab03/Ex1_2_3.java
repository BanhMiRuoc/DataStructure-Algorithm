public class Ex1_2_3 {
    public static int factorial(int n) {
        int rs = 1;
        while(n > 1) {
            rs *= n ;
            n--;
        }
        return rs;
    }
    public static int exponent(int n, int x) {
        int rs = x;
        for(int i = 1; i < n; i++) {
            rs *= x;
        }
        return rs;
    }
    public static int countNumber(int n) {
        int count = 0;
        while (n > 0) {
            n = n/10 ;
            count++;
        }
        return count;
    }
    public static int greatestCommonD(int a, int b){
        int rs = 1;
        for(int i = 1; i < a || i < b; i++) {
            if(a%i == 0 && b%i == 0) {
                rs = i;
            }
        }
        return rs;
    }
    public static boolean isPrime(int n) {
        if(n < 2 || n%2 == 0)   return false;
        else if(n == 2) return true;
        for(int i = 3; i*i < n; i += 2)
            if(n%i == 0)    return false;
        return true;
    }
    public static boolean checkPrime(int n, int i) {
        if (n == 2 || i*i > n)   return true;
        else if (n % i == 0 || n < 2)   return false;
        return checkPrime(n, i + 2);
    }
    public static int gcd(int a, int b) {
        return (a == b) ? b: (a > b) ? gcd(a/b, b) : gcd(a, b/a); 
    }
    public static int countNum(int n, int count) {
        if (n <= 0) return count++;
        else {
            count += 1;
            return countNum(n/10, count);
        }
    }
    public static int expo(int n, int x) {
        return (n == 0 || n == 1) ? x : x*expo(n - 1, x);
    }
    public static int fac(int n) {
        return (n == 1 || n == 0) ? 1 : n*fac(n-1);
    }

    public static void main(String[] args) {
        // System.out.println(factorial(5));
        // System.out.println(fac(5));
        // System.out.println(exponent(4, 2));
        // System.out.println(expo(4, 2));
        // System.out.println(countNumber(1234));
        // System.out.println(countNum(1234, 0));
        // System.out.println(greatestCommonD(36, 6));
        // System.out.println(gcd(6, 36));
        System.out.println(isPrime(11));
        System.out.println(checkPrime(11, 2));
    }
}