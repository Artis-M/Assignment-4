public class Guardsmen implements WriterInterface
{
    private TreasureRoom treasureRoom;

    public Guardsmen()
    {
        this.treasureRoom = new TreasureRoom();
    }

    @Override
    public void addValuable(Valuable valuable)
    {
        treasureRoom.addValuable(valuable);
    }

    @Override
    public Valuable retrieveValuable(int index)
    {
        return treasureRoom.retrieveValuable(index);
    }

    @Override
    public Valuable look(int index)
    {
        return treasureRoom.look(index);
    }

    @Override
    public int size()
    {
        return treasureRoom.size();
    }
}
