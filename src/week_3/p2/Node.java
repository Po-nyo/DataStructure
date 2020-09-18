package week_3.p2;

public class Node {
    public int item;
    public Node next;

    public Node(int item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(int item) {
        this(item, null);
    }
}
