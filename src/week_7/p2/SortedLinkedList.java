package week_7.p2;

import week_7.List;

public class SortedLinkedList<T extends Comparable<T>> implements List<T> {

    static class Node<T> {
        private T item;
        private Node<T> link;

        private Node(T item) {
            this(item, null);
        }

        private Node(T item, Node<T> link) {
            this.item = item;
            this.link = link;
        }
    }

    private Node<T> head;
    private int size;
    private Node<T> scanPos;

    public SortedLinkedList() {
        this.head = null;
        this.size = 0;
        this.scanPos = null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void insert(T item) {
        if(isEmpty()) {
            this.head = new Node(item);;
        }
        else {
            Node<T> prev = null;
            Node<T> current = this.head;

            while(current != null) {
                if(item.compareTo(current.item) <= 0)
                    break;

                prev = current;
                current = current.link;
            }

            if(prev == null)
                this.head = new Node(item, head);
            else
                prev.link = new Node(item, prev.link);
        }
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void reset() {
        this.scanPos = this.head;
    }

    @Override
    public boolean hasNext() {
        return this.scanPos != null;
    }

    @Override
    public T next() {
        T item = this.scanPos.item;
        this.scanPos = this.scanPos.link;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> temp = this.head;
        while(temp != null) {
            sb.append(temp.item);
            temp = temp.link;
        }

        return sb.toString();
    }
}
