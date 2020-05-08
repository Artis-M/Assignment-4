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
    log.log("Valuable was added to the Treasure Room: " + valuable.getName());
  }

  @Override public Valuable retrieveValuable()
  {
    Valuable valuable = list.get(list.size() - 1);
    return list.remove(valuable);
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
