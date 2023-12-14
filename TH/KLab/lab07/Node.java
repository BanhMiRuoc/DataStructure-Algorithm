public class Node {
    Integer key;
    Node left, right;
    int height;
    
    public Node(Integer key) {
        this.key = key;
        left = right = null;
        height = 0;
    }
}