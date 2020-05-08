import utility.collection.ArrayList;

public class ValuableDepository<Valuable> implements Deposit<Valuable>
{
  private ArrayList<Valuable> arrayList;
  private Logger log;

  public ValuableDepository()
  {
    arrayList = new ArrayList<>();
    log = Logger.getInstance();
  }

  @Override public synchronized void enqueue(Valuable valuable)
  {

    arrayList.add(valuable);

  }

  @Override public synchronized Valuable dequeue()
  {
    if (arrayList.size() > 0)
    {
      return arrayList.remove(arrayList.size() - 1);
    }
    else
    {
      log.log("Empty deposit.");
      return null;
    }
  }

  @Override public synchronized Valuable getLastValue()
  {
    return arrayList.get(arrayList.size() - 1);
  }

  @Override public synchronized Valuable getValuableAtIndex(int index)
  {
    if (!arrayList.isEmpty())
    {
      return arrayList.get(index);
    }

    return null;
  }

  @Override public synchronized void clear()
  {
    for (int i = 0; i < arrayList.size(); i++)
    {
      arrayList.remove(i);
    }
  }

  @Override public synchronized int size()
  {
    return arrayList.size();
  }

  @Override public boolean isEmpty()
  {
    return arrayList.isEmpty();
  }

}
