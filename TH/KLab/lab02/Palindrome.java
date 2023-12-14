public class Palindrome {
    public boolean isPalindrome(String a) {
        MyStack<Character> stack = new MyStack<>();
        MyQueue<Character> queue = new MyQueue<>();
        for(char c: a.toCharArray()) {
            stack.push(c);
            queue.enQueue(c);
        }
        while(!stack.isEmpty()) {
            if(stack.pop().equals(queue.deQueue())) {
                return true;
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]) {
        Palindrome n = new Palindrome();
        System.out.println(n.isPalindrome("daad"));

    }
}