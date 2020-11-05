package week_8;

public class UnsortedLinkedList<T> {

    private static class Node<T> {
        private T item;
        private Node<T> next;

        private Node(T item) {
            this(item, null);
        }

        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public UnsortedLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        print(head);
        System.out.println();
    }

    private void print(Node<T> node) {
        if (node != null) {
            System.out.print(node.item + " ");
            print(node.next);
        }
    }

    public void insertFirst(T item) {
        head = new Node<T>(item, head);
        size++;
    }

    public T getNthItem(int nth) {
        return getNthItem(head, nth);
    }

    private T getNthItem(Node<T> node, int n) {
        if(n == 1)
            return node.item;
        else
            return getNthItem(node.next, n-1);
    }

    public boolean search(T item) {
        return search(head, item);
    }

    private boolean search(Node<T> node, T item) {
        if(node.item.equals(item))
            return true;
        else if(node.next != null) {
            return search(node.next, item);
        }
        else
            return false;
    }

    public void insertLast(T item) {
        if(head == null)
            head = new Node<>(item);
        else
            insertLast(head, item);
        size++;
    }

    private void insertLast(Node<T> node, T item) {
        if(node.next == null)
            node.next = new Node<>(item);
        else
            insertLast(node.next, item);
    }

    public boolean removeFirst(T item) {
        int tmpSize = size;
        head = removeFirst(head, item);
        return tmpSize != this.size;
    }

    private Node<T> removeFirst(Node<T> node, T item) {
        if (node == null)
            return null;
        else if (node.item.equals(item)) {
            size--;
            return node.next;
        }
        else {
            node.next = removeFirst(node.next, item);
            return node;
        }
    }

    public boolean removeAll(T item) {
        int tmpSize = size;
        head = removeAll(head, item);
        return tmpSize != size;
    }

    private Node<T> removeAll(Node<T> node, T item) {
        if(node == null)
            return null;
        else if(node.item.equals(item)) {
            size--;
            return node.next = removeAll(node.next, item);
        }
        else {
            node.next = removeAll(node.next, item);
            return node;
        }
    }

    public void reversePrint() {
        reversePrint(head);
        System.out.println();
    }

    private void reversePrint(Node<T> node) {
        if(node != null) {
            reversePrint(node.next);
            System.out.print(node.item + " ");
        }
    }

    public UnsortedLinkedList<T> copy() {
        UnsortedLinkedList<T> newList = new UnsortedLinkedList<>();

        if(!isEmpty())
            newList.head = copy(this.head);
        newList.size = this.size;

        return newList;
    }

    private Node<T> copy(Node<T> targetListNode) {
        if(targetListNode == null)
            return null;
        else {
            Node<T> newNode = new Node<>(targetListNode.item);
            newNode.next = copy(targetListNode.next);
            return newNode;
        }
    }
}
