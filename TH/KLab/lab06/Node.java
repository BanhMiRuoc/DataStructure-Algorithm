public class Node {
    Integer key;
    Node left, right;

    public Node(Integer key) {
        this.key = key;
        left = right = null;
    }
    public String toString() {
        return key + " ";
    }
}