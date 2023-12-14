import java.util.Stack;
public class ex2_1 {
    public static String InfixToPostfix(String s) {
        // String q = s.split(" ").toString();
        Stack<Character> postfix = new Stack<>();
        String result = "";
        char[] character = s.toCharArray();
        for(char ch: character) {
            if(Character.isLetterOrDigit(ch))
                result+=ch;
            else if (ch == '(') {
                postfix.push(ch);
            }
            else if (ch == ')') {
                while(!postfix.isEmpty() && postfix.peek() != '(') {
                    result+= postfix.pop();
                }
                if(!postfix.isEmpty() && postfix.peek() != '(')
                    return "Invalid";
                else {
                    postfix.pop();
                }
            }
            else {
                while(!postfix.isEmpty() && checkOp(ch) <= checkOp(postfix.peek())) {
                    if(postfix.peek() == '(')
                        return "invalid";
                    result += postfix.pop();
                }
                postfix.push(ch);
            }
        }
        while (!postfix.isEmpty()){ 
            if(postfix.peek() == '(') 
                return "Invalid Expression"; 
            result += postfix.pop(); 
        }
        return result; 
    }
    static int checkOp(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
    public static void main(String[] args) {
        System.out.println(InfixToPostfix("a+b-c*d^g-(e+f)"));
    }

}