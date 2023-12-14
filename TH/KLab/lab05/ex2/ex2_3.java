import java.util.Stack;
public class ex2_3 {
    public static boolean checkPalindrome(int num) {
        Stack<Integer> st = new Stack<Integer>();
        boolean check = true;
        int numCheckLen = num;
        int len = 0;
        while (numCheckLen > 0) {
            len += 1;
            st.push(numCheckLen % 10);
            numCheckLen /= 10;
        }
        
        int count = 0;
        while (num > 0) {
            if (count == len/2) {
                return check;
            }
            int tmp = num % 10;
            if (tmp != st.pop()) {
                check = false;
                return check;
            }
            count++;
            num /= 10;
        }
        return check;
    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome(132));
        System.out.println(checkPalindrome(131));
        System.out.println(checkPalindrome(1331));
    }
}