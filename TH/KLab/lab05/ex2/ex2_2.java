import java.util.Stack;

public class ex2_2 {
    public static String CalculatePostfixExpression(String s) {
        Stack<String> st = new Stack<String>();
        String[] split_ch = s.split(" ");
        String operator = "+-*/^";

        for (String ch : split_ch) {
            int kind = operator.indexOf(ch.charAt(0));
            if (kind >= 0) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int res = b;
                switch (kind) {
                    case 0:
                        res = b + a;
                        break;
                    case 1:
                        res = b - a;
                        break;
                    case 2:
                        res = b * a;
                        break;
                    case 3:
                        res = b / a;
                        break;
                    case 4:
                        res = (int)Math.pow(b, a);
                        break;
                }
                st.push(res + "");
            }
            else {
                st.push(ch);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println(CalculatePostfixExpression("7 2 -"));
    }
}
