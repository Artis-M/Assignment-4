import utility.collection.ArrayList;

public class TreasureRoom implements WriterInterface
{
  private ArrayList<Valuable> list;
  private Logger log;

  public TreasureRoom()
  {
    this.list = new ArrayList<>();
    this.log = Logger.getInstance();
  }

  @Override public void addValuable(Valuable valuable)
  {
    list.add(valuable);
    log.log("Valuable was added to the Treasure Room: " + valuable);
  }

  @Override public Valuable retrieveValuable(int index)
  {
    Valuable valuable = list.get(index);
    list.remove(index);
    return valuable;
  }

  @Override public Valuable look(int index)
  {
    return list.get(index);
  }

  @Override public int size()
  {
    return list.size();
  }
}
