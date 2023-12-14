public class AVL {
    private Node root;
    
    public AVL() {
        root = null;
    }
    private int height(Node x) {
        return (x == null) ? -1 : x.height;
    }
    private int maxHeight(Node x) {
        return (height(x.left) > height(x.right)) ? x.left.key : x.right.key;
    }
    private int bf(Node x) {
        return (x == null) ? 0 : (height(x.left) - height(x.right));
    }
    public Node RR(Node x) {
        Node y = x.left;
        Node z = y.right;
        //change
        y.right = x;
        x.left = z;
        //update height
        x.height = maxHeight(x) + 1;
        y.height = maxHeight(y) + 1;

        return y;
    }
    public Node LR(Node x) {
        Node y = x.right;
        Node z = y.left;
        
        y.left = x;
        x.right = z;

        x.height = maxHeight(x) + 1;
        y.height = maxHeight(y) + 1;

        return y;
    }
    private Node insert(Node x, Integer key) {
        if(x == null) {
            if (root == null)   root = new Node(key);
            return new Node(key);
        }
        int cmp = key.compareTo(x.key);
        if(cmp >= 0) {
            x.right = insert(x.right, key);
        }
        else if(cmp < 0) {
            x.left = insert(x.left, key);
        }
        else  {
            x.height = 1 + maxHeight(x);
            if(bf(x) == 2) {
                if(bf(x.left) == 1)
                    return RR(x);
                else {
                    x.left = LR(x.left);
                    return RR(x);
                }
            }
            if(bf(x) == -2) {
                if(bf(x.right) == -1)
                    return LR(x);
                else {
                    x.right = RR(x.right);
                    return LR(x);
                }
            }
        }
        return x;
    }
    public Node insert(Integer key) {
        return insert(root, key);
    }
    private void inOrder(Node x) {
        if(x != null) {
            inOrder(x.left);
            System.out.println(x.key + " ");
            inOrder(x.right);
        }
    }
    public void inOrder() {
        inOrder(root);
    }
}