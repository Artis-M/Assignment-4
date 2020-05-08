import utility.collection.ArrayList;

public class TreasureRoomMonitor<Valuable> implements TreasureRoomDoor<Valuable>
{
  private int readers;
  private int writer;
  private int waitingWriters;
  private Guard guard;
  private ArrayList<Valuable> list;

  public TreasureRoomMonitor(Guard guard)
  {
    this.readers = 0;
    this.writer = 0;
    this.waitingWriters = 0;
    this.list = new ArrayList<>();
    this.guard = guard;
  }

  @Override public synchronized ReaderInterface acquireRead()
  {
    while (waitingWriters > 0 || writer > 0)
    {
      try
      {
        wait();
      }
      catch (Exception e)
      {
        e.printStackTrace();

      }
    }
    readers++;
    return guard;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers == 0)
    {
      notify();
    }
  }

  @Override public synchronized WriterInterface acquireWrite()
  {
    waitingWriters++;
    while (readers > 0 || writer > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriters--;
    writer++;
    return guard;
  }

  @Override public synchronized void releaseWrite()
  {
    writer--;
    notifyAll();
  }

}
