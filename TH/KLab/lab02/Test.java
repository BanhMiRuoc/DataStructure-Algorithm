public class Test {
    public static void main(String args[]) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enQueue(6);
        System.out.println("front: " + queue.getFront());
        queue.print();
        queue.enQueue(1);
        System.out.println("front: " + queue.getFront());
        queue.print();
        // queue.enQueue(5);
        // queue.enQueue(2);
        queue.deQueue();
        queue.print();
        System.out.println("front: " + queue.getFront());
    }
}
