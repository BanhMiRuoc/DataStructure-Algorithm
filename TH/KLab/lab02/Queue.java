public class Queue <E>{
    private MyStack<E> stack1;
    private MyStack<E> stack2;

    public Queue() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }
    public void enQueue(E element) {
        stack1.push(element);
    } 
    public E deQueue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String args[]) {
        Queue<Integer> nq = new Queue<>();
        nq.enQueue(4);
        nq.enQueue(6);
        nq.enQueue(5);
        System.out.println(nq.deQueue());
    }
}
