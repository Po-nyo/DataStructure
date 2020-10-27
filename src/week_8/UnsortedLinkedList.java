package week_8;

public class UnsortedLinkedList<T> {

    private static class Node<T> {
        private T item;
        private Node<T> next;

        private Node() {next = null;}

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

    public void print() {		// 재귀로 구현
        print(head);
        System.out.println();
    }

    private void print(Node<T> node) {
        if (node != null) {
            System.out.print(node.item + " ");
            print(node.next);
        }
    }

    public void insertFirst(T item) {	// 맨 앞에 삽입
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
            head = new Node<T>(item);
        else
            insertLast(head, item);
        size++;
    }

    private void insertLast(Node<T> node, T item) {
        if(node.next == null)
            node.next = new Node<T>(item);
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
        return false;
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

        if(!isEmpty()) {
            newList.head = new Node<>(this.head.item);
            newList.size++;
            copy(newList, newList.head, this.head.next);
        }

        return newList;
    }

    private void copy(UnsortedLinkedList<T> newList, Node<T> newListNode, Node<T> targetListNode) {
        if(targetListNode != null) {
            newListNode.next = new Node<T>(targetListNode.item);
            copy(newList, newListNode.next, targetListNode.next);
            newList.size++;
        }
    }
}
