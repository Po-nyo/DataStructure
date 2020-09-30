package week_5;

public interface Queue<T> {

    public void enqueue(T item);
    public T dequeue();
    public T peek();
    public boolean isEmpty();
    public void clear();
    public int size();
}
