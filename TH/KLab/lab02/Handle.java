public class Handle {
    public int E_recursion(int n) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(n);
        int rs = 3;
        while (!stack.isEmpty()) {
            n = stack.pop();
            if (n > 1) {
                stack.push(n - 1);
                rs += Math.pow(2, n) + Math.pow(n, 2);
            }
        }
        return rs;
    }

    public double recursion(int n) {
        return (n == 1) ? 3:  Math.pow(2, n) + Math.pow(n, 2) + recursion(n-1);
    }
    public static void main(String[] args) {
        Handle n = new Handle();
        System.out.println(n.recursion(3));
        //de qui - de bai yeu cau khu de qui use loop
        System.out.println(n.E_recursion(3));
    }
}
