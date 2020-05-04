import utility.collection.ArrayList;

public class ValuableDepository<Valuable> implements Deposit<Valuable>
{
  private ArrayList<Valuable> arrayList;
  private int size;
  private Logger log;

  public ValuableDepository(int size)
  {
    arrayList = new ArrayList<>();
    this.size = size;
    log = Logger.getInstance();
  }

  @Override public synchronized void enqueue(Valuable valuable)
  {
    if (arrayList.size() < size)
    {
      arrayList.add(valuable);
    }
    else
    {
      log.log("ValuableDepository is full.");
    }
  }

  @Override public synchronized Valuable dequeue()
  {
    if (arrayList.size() > 0)
    {
      return arrayList.remove(arrayList.size());
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

}
