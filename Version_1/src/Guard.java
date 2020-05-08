public class Guard implements WriterInterface
{
  private TreasureRoom treasureRoom;

  public Guard()
  {
    this.treasureRoom = new TreasureRoom();
  }

  @Override public void addValuable(Valuable valuable)
  {
    treasureRoom.addValuable(valuable);
  }

  @Override public Valuable retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public Valuable look(int index)
  {
    return treasureRoom.look(index);
  }

  @Override public int size()
  {
    return treasureRoom.size();
  }
}
