public class DoubleNode <Double>{
    private double data;
    private DoubleNode<Double> next;

    public DoubleNode() {
        this(0.0, null);
    }
    public DoubleNode(double data) {
        this.data = data;
        next = null;
    }
    public DoubleNode(double data, DoubleNode<Double> next) {
        this.data = data;
        this.next = next;
    }
    public double getData() {
        return data;
    }
    public DoubleNode <Double> getNext() {
        return next;
    }
    public void setNext(DoubleNode <Double> curr) {
        next = curr;
    }
}
