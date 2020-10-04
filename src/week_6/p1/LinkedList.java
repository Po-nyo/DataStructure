package week_6.p1;

import week_6.List;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    private static class Node<T> {
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
    private Node<T> scanPos;
    private int size;

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void insert(T item) {
        this.head = new Node<T>(item, this.head);
        this.size++;
    }

    @Override
    public boolean remove(T item) {
        if(isEmpty())
            throw new NoSuchElementException("remove: List is empty!");

        Node<T> prev = null;
        Node<T> current = this.head;

        while(current != null) {
            if(current.item.equals(item))
                break;
            prev = current;
            current = current.link;
        }

        if(current == null)
            return false;
        else if(prev == null)
            this.head = this.head.link;
        else
            prev.link = current.link;

        this.size--;

        return true;
    }

    @Override
    public boolean search(T item) {
        if(isEmpty())
            throw new NoSuchElementException("search: List is empty!");

        Node<T> target = head;
        while(target != null) {
            if(target.item.equals(item))
                return true;
            target = target.link;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void reset() {
        this.scanPos = head;
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
    public void insert(int num, T item) {
        if((num > this.size || num <= 0) && num != 1)
            throw new NoSuchElementException("insert: Wrong position!");

        if(this.head == null || num == 1)
            insert(item);
        else {
            Node<T> target = getNth(num - 1);
            target.link = new Node<T>(item, target.link);
        }
    }

    @Override
    public void delete(int num) {
        if(num > this.size || num <= 0)
            throw new NoSuchElementException("delete: Wrong position!");

        if(num == 1)
            this.head = this.head.link;
        else {
            Node<T> target = getNth(num - 1);
            target.link = target.link.link;
        }

    }

    @Override
    public void append(T item) {
        if(this.head == null)
            this.head = new Node<T>(item);
        else {
            Node<T> target = getNth(this.size);
            target.link = new Node<T>(item);
        }
    }

    @Override
    public T retrieve(int num) {
        if(num > this.size || num <= 0)
            throw new NoSuchElementException("retrieve: Wrong position!");
        return getNth(num).item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> scan = this.head;
        while(scan != null) {
            sb.append(scan.item + " ");
            scan = scan.link;
        }

        return sb.toString();
    }

    private Node<T> getNth(int num) {
        Node<T> target = this.head;

        for(int i=1; i<num; i++)
            target = target.link;

        return target;
    }
}
