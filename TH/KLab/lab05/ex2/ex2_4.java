import java.util.Stack;
public class ex2_4 {
    public static String reverseString(String s) {
        Stack<String> st = new Stack<String>();
        String[] spl = s.split("\\s+");
        String result = "";
        for (int i = spl.length - 1; i >= 0; i--) {
            result += spl[i] + " ";
        }
        return result.trim();
    }
    public static void main(String[] args) {
        System.out.println(reverseString("I like apple"));
    }
}
