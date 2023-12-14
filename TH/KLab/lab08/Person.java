public class Person {
    private String name;
    private int priority;

    public Person(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "[" + this.name + ", " + this.priority + "]";
    }
}