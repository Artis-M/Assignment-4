public interface Deposit<T> {
    public void enqueue(T object);
    public T dequeue();
    public T getLastValue();
    public void clear();
}
