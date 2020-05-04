public interface Deposit<T> {
    public void enqueue(T object);
    public T dequeue();
}
