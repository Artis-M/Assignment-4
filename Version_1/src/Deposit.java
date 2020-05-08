public interface Deposit<Valuable> {
    public void enqueue(Valuable valuable);
    public Valuable dequeue(int index);
    public Valuable getLastValue();
    public Valuable getValuableAtIndex(int index);
    public void clear();
    public int size();
}
