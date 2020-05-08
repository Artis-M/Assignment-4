public interface TreasureRoomDoor<Valuable>
{
  ReaderInterface acquireRead();

  void releaseRead();

  WriterInterface acquireWrite();

  void releaseWrite();

}
