package week_7;

public interface List<T> {
    public boolean isEmpty();
    public void insert(T item);
    public int size();
    public String toString();

    public void reset();
    public boolean hasNext();
    public T next();
}
