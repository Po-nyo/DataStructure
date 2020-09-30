package week_5.p2;

import week_5.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int maxSize;

    public ArrayQueue() {
        this(3);
    }

    public ArrayQueue(int maxSize) {
        this.array = (T[])new Object[maxSize];
        this.front = 0;
        this.rear = maxSize - 1;
        this.size = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void enqueue(T item) {
        if(isFull())
            resize();
        this.rear = (this.rear + 1) % this.maxSize;
        this.array[this.rear] = item;
        this.size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("dequeue: Queue is Empty!");
        else {
            T item = this.array[this.front];
            this.front = (this.front + 1) % this.maxSize;
            this.size--;
            return item;
        }
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException("peek: Queue is Empty!");
        return this.array[this.front];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }

    @Override
    public void clear() {
        this.maxSize = 3;
        this.size = 0;
        this.front = 0;
        this.rear = this.maxSize - 1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int temp = this.front;
        for(int i=0; i<this.size; i++) {
            sb.append(array[temp] + " ");
            temp = (temp + 1) % this.maxSize;
        }

        return sb.toString();
    }

    public void resize() {
        T[] newArray = (T[]) new Object[2 * this.maxSize];
        int idx = this.front;
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[idx];
            idx = (idx + 1) % this.maxSize;
        }
        this.array = newArray;
        this.front = 0;
        this.rear = this.maxSize - 1;
        this.maxSize = 2 * this.maxSize;
    }
}
