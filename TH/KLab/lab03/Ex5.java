public class Ex5 {
    public static void convert(int n, int b) {
        if (n > 0) {
            convert(n/b, b);
            System.out.println(n%b);
        }
    }
}
