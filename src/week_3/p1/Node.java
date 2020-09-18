package week_3.p1;

public class Node {
    public Date item;
    public Node next;

    public Node(Date item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(Date item) {
        this(item, null);
    }
}
