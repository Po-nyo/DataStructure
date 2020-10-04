package week_6.p2;

import java.util.NoSuchElementException;

public class ArrayList<T> {

    private T[] items;
    private int size;
    private int maxSize;
    private int scanPos;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int max) {
        this.items = (T[])new Object[max];
        this.maxSize = max;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == maxSize;
    }

    public int size() {
        return this.size;
    }

    public void insert(T item) {
        if(isFull())
            resize();
        this.items[size++] = item;
    }

    public boolean remove(T item) {
        for(int i=0; i<this.size; i++) {
            if(this.items[i].equals(item)) {
                this.items[i] = this.items[--this.size];
                return true;
            }
        }

        return false;
    }

    public boolean search(T item) {
        if(isEmpty())
            throw new NoSuchElementException("search: List is empty!");

        for(int i=0; i<this.size; i++) {
            if(this.items[i].equals(item))
                return true;
        }

        return false;
    }

    public void resize() {
        T[] newItems = (T[])new Object[2 * this.maxSize];

        for(int i=0; i<items.length; i++)
            newItems[i] = items[i];

        this.items = newItems;
        this.maxSize *= 2;
    }

    public void reset() {
        this.scanPos = 0;
    }

    public boolean hasNext() {
        return this.scanPos < this.size;
    }

    public T next() {
        return this.items[this.scanPos++];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<this.size; i++)
            sb.append(this.items[i] + " ");

        return sb.toString();
    }
}
