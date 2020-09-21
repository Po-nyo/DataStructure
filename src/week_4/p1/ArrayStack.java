package week_4.p1;

import week_4.Stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] array;
    private int size;
    private int maxSize = 50;

    public ArrayStack() {
        this.array = (T[])new Object[maxSize];
        this.size = 0;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        return array[size-1];
    }

    @Override
    public T pop() {
        return array[--size];
    }

    @Override
    public void push(T item) {
        array[size++] = item;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String str = "";

        for(int i=0; i<this.size; i++) {
            str = this.array[i] + " " + str;
        }

        return str;
    }
}
