public class Reverse {
    public String reverseStack(String a) {
        MyStack<Character> stack = new MyStack<>();
        for (char c: a.toCharArray())
            stack.push(c);
        StringBuffer reverseString = new StringBuffer();
        while(!stack.isEmpty()) {
            reverseString.append(stack.pop());
        }
        return reverseString.toString();
    }
    public static void main(String[] args) {
        Reverse h = new Reverse();
        System.out.println(h.reverseStack("Mai Trang"));
    }
}
