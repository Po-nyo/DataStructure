package week_4.p1;

import week_4.Stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] array;
    private int top;
    private int maxSize = 50;

    public ArrayStack() {
        this.array = (T[])new Object[maxSize];
        this.top = 0;
    }

    @Override
    public void clear() {
        this.top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public T peek() {
        return array[top];
    }

    @Override
    public T pop() {
        return array[top--];
    }

    @Override
    public void push(T item) {
        array[++top] = item;
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public String toString() {
        String str = "";

        for(int i = 0; i<this.top; i++) {
            str = this.array[i] + " " + str;
        }

        return str;
    }
}
