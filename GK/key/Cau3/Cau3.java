import java.util.Stack;

public class Cau3 {
    public static int calculate(String[] expression) {
        // code here
        Stack<Integer> s = new Stack<>();
        int length = expression.length;
        for(int i = 0; i < length; i++) {
            if(isNumber(expression[i])) {
                s.push(Integer.parseInt(expression[i]));
                // count++;
            }
            if(expression[i] == "+")
                s.push(s.pop() + s.pop()); 
            else if(expression[i] == "-")
                s.push(s.pop() - s.pop()); 
            else if(expression[i] == "*")
                s.push(s.pop() * s.pop()); 
            else if(expression[i] == "/")
                s.push(s.pop() / s.pop()); 
        }
        return s.pop();
    }
    public static boolean isNumber(String str) {
        return str.matches("0|([1-9][0-9]*)");
    }
    public static void main(String args[]){
		System.out.println(calculate(new String[]{"31", "12", "+"}));
		System.out.println(calculate(new String[]{"3", "1", "*", "4", "5", "+", "+"}));
	}
}