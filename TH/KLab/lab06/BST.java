public class BST {
    private Node root;
    private Integer key;

    public BST(Node x) {
        root = x;
    }
    private Node insert(Node x, Integer key) {
        if(x == null)
            return new Node(key);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = insert(x.left, key);
        else if(cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;
        return x;
    }
    public Node insert(Integer key) {
        return insert(root, key);
    }
    private void nlr(Node x) {
        if(x != null) {
            System.out.print(x.key + " ");
            nlr(x.left);
            nlr(x.right);
        }
    }
    public void nlr() {
        nlr(root);
    }
    private void lnr(Node x) {
        if(x != null) {
            lnr(x.left);
            System.out.print(x.key + " ");
            lnr(x.right);
        }
    }
    public void lnr() {
        lnr(root);
    }
    private void lrn(Node x) {
        if(x != null) {
            lrn(x.left);
            lrn(x.right);
            System.out.print(x.key + " ");
        }
    }
    public void lrn() {
        lrn(root);
    }
    private Node search(Node x, Integer key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            return search(x.right, key);
        else if(cmp < 0)
            return search(x.left, key);
        return x;
    }
    public boolean search(Integer key) {
        return (search(root, key) != null);
    }
    private Node min(Node x) {
        if(x.left ==  null)
            return x;
        return min(x.left);
    }
    public Node min(){
        return min(root);
    }
    private Node max(Node x) {
        if(x.right ==  null)
            return x;
        return max(x.right);
    }
    public Node max(){
        return max(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    public Node deleteMin() {
        return deleteMin(root);
    }
    private Node deleteMax(Node x){
        if(x.right == null)
            return x.left;
        x.right = deleteMin(x.right);
        return x;
    }
    public Node deleteMax() {
        return deleteMax(root);
    }
    private Node delete(Node x, Integer key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }
        return x;
    }
    public Node delete(Integer key) {
        return delete(root, key);
    }
    private int height(Node x) {
        if (x == null)
            return -1;
        return Math.max(height(x.left), height(x.right)) + 1;
    }
    public int height() {
        return height(root);
    }
    private boolean contains(Node x, Integer key) {
        if (key == null || x == null)       return false;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            return contains(x.right, key);
        else if (cmp < 0)
            return contains(x.left, key);
        else
            return true;
    }
    public boolean contains(Integer key) {
        return contains(root, key);
    }
    private void delete_pre(Node x, Integer key) {
        if (key != null ) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0)
                delete_pre(x.right, key);
            else if (cmp < 0)
                delete_pre(x.left, key);
            else {
               delete(max(x.left).key);
            }
        }
    }
    public void delete_pre(Integer key) {
        delete_pre(root, key);
    }
    private Integer sum(Node x) {
        if(x == null) {
            return 0;
        }
        return sum(x.left) + sum(x.right) + x.key;
    }
    public Integer sum() {
        return sum(root);
    }
    private Integer sumEven(Node x) {
        if (x==null)    return 0;
        int sum = 0;
        if (x.key%2 == 0)
            sum += x.key;
        return sum += sumEven(x.left) + sumEven(x.right);
    }
    public Integer sumEven() {
        return sumEven(root);
    }
    private int countLeaves(Node x) {
        if (x == null) return 0;
        int sum = 0;
        if(x.right==null && x.left == null)
            sum++;
        return sum += countLeaves(x.right) + countLeaves(x.left);
    }
    public int countLeaves() {
        return countLeaves(root);
    }
    private int sumEvenKeyAtLeaves(Node x) {
        if(x == null)  return 0;
        int sum = 0;
        if (x.right == null && x.left == null && x.key%2 == 0)
            sum += x.key;
        return sum += sumEvenKeyAtLeaves(x.right) + sumEvenKeyAtLeaves(x.left);
    }
    public int sumEvenKeyAtLeaves() {
        return sumEvenKeyAtLeaves(root);
    }
    private void bfs(Node x, int height) {
        if (x == null)  return;
        if(height == 1)
            System.out.print(x.key + " ");
        else if (height > 1) {
            bfs(x.left, height - 1);
            bfs(x.right, height - 1);
        }
    }
    public void bfs() {
        for(int i = 1; i <= height(); i++)
            bfs(root, i);
    }
}
