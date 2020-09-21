package week_4.p2;

import week_4.Stack;

public class LinkedStack<T> implements Stack<T> {

    static class Node<T> {
        private T item;
        private Node<T> next;

        private Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        private Node(T item) {
            this(item, null);
        }
    }

    private Node<T> head;
    private int size;

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        return head.item;
    }

    @Override
    public T pop() {
        Node<T> target = head;
        this.head = head.next;
        this.size--;

        return target.item;
    }

    @Override
    public void push(T item) {
        this.head = new Node<T>(item, head);
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> temp = this.head;

        while(temp != null) {
            str += " " + temp.item;
            temp = temp.next;
        }

        return str;
    }
}
