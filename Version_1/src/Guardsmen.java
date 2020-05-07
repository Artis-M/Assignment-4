public class Guardsmen implements TreasureRoomDoor<Valuable>
{
    private TreasureRoom<Valuable> treasureRoom;

    public Guardsmen()
    {
        this.treasureRoom = new TreasureRoom<>();
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
    public void acquireRead()
    {
        treasureRoom.acquireRead();
    }

    @Override
    public int size()
    {
        return treasureRoom.size();
    }

    @Override
    public void acquireWrite()
    {
        treasureRoom.acquireWrite();
    }
}
