public interface TreasureRoomDoor<Valuable>
{
    void addValuable(Valuable valuable);

    Valuable retrieveValuable(int index);

    Valuable look(int index);

    void acquireRead();

int size();

    void acquireWrite();


}
