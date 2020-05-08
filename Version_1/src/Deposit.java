public interface Deposit<Valuable>
{
  void enqueue(Valuable valuable);
  Valuable dequeue();
  Valuable getLastValue();
  Valuable getValuableAtIndex(int index);
  void clear();
  int size();
  boolean isEmpty();
}
