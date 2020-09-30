package week_5.p1;

import week_5.Queue;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

    static class Node<T> {
        private T item;
        private Node<T> link;

        private Node(T item, Node<T> link) {
            this.item = item;
            this.link = link;
        }

        private Node(T item) {
            this(item, null);
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node newNode = new Node(item);

        if(this.size++ == 0)
            this.front = newNode;
        else
            this.rear.link = newNode;

        this.rear = newNode;
    }

    @Override
    public T dequeue() {
        if(this.isEmpty())
            throw new NoSuchElementException("Queue is Empty!");
        else {
            T item = this.front.item;
            this.front = this.front.link;

            if(this.front == null)
                this.rear = null;

            size--;

            return item;
        }
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new NoSuchElementException("Queue is Empty!");
        else
            return this.front.item;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node target = this.front;
        while(target != null) {
            sb.append(target.item + " ");
            target = target.link;
        }

        return sb.toString();
    }
}
