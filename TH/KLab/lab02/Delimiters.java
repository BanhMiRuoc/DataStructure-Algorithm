public class Delimiters {
    public boolean isBalanced(String a) {
        MyStack<Character> stack = new MyStack<>();
        for(char c: a.toCharArray()){
            if(c == '(' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == '}') {
                if(stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
