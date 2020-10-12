package week_7.p1;

import week_7.List;

import java.util.NoSuchElementException;

public class SortedArrayList<T extends Comparable<T>> implements List<T> {

    private T[] items;
    private int size;
    private int maxSize;
    private int scanPos;

    public SortedArrayList() {
        this(3);
    }

    public SortedArrayList(int max) {
        this.size = 0;
        this.maxSize = max;
        this.items = (T[])new Comparable[max];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }

    @Override
    public void insert(T item) {
        if(isFull())
            resize();

        if(isEmpty())
            this.items[this.size++] = item;
        else {
            int low = 0;
            int high = this.size - 1;
            int pos = 0;

            while(low <= high) {
                int mid = (low + high) / 2;
                T midItem = this.items[mid];

                if(item.compareTo(midItem) == 0) {
                    pos = mid;
                    break;
                }
                else if(item.compareTo(midItem) > 0) {
                    low = mid + 1;
                    pos = low;
                }
                else {
                    high = mid - 1;
                    pos = high;
                }
            }

            if(pos < 0)
                pos = 0;
            else if(pos < this.size && item.compareTo(this.items[pos]) > 0)
                pos += 1;

            for(int i=++this.size-1; i>pos; i--)
                this.items[i] = this.items[i-1];

            this.items[pos] = item;
        }
    }

    public boolean remove(T item) {
        int pos = findItem(item);

        if(pos == -1)
            return false;

        this.size--;

        for(int i=pos; i<=size-1; i++)
            this.items[i] = this.items[i+1];

        return true;
    }

    public boolean search(T item) {
        if(isEmpty())
            throw new NoSuchElementException("search: List is empty!");

        return findItem(item) != -1;
    }

    private int findItem(T item) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midItem = items[mid];
            if (item.compareTo(midItem) > 0)
                low = mid + 1;
            else if (item.compareTo(midItem) < 0)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void reset() {
        this.scanPos = 0;
    }

    @Override
    public boolean hasNext() {
        return this.scanPos < this.size;
    }

    @Override
    public T next() {
        return items[scanPos++];
    }

    public void resize() {
        T[] newItems = (T[]) new Comparable[2 * this.items.length];

        for (int i=0; i<this.items.length; i++)
            newItems[i] = this.items[i];

        this.items = newItems;
        this.maxSize = this.maxSize * 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<this.size; i++)
            sb.append(this.items[i] + " ");

        return sb.toString();
    }
}
