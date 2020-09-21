package week_4;

public interface Stack<T> {

    public void clear();
    public boolean isEmpty();
    public T peek();
    public T pop();
    public void push(T item);
    public int size();
}
