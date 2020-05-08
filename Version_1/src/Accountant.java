public class Accountant implements Runnable
{
  private TreasureRoomMonitor<Valuable> treasureRoomMonitor;
  private Logger log;

  public Accountant(TreasureRoomMonitor<Valuable> treasureRoomMonitor)
  {
    this.log = Logger.getInstance();
    this.treasureRoomMonitor = treasureRoomMonitor;
  }

  @Override public void run()
  {
    while (true)
    {
      ReaderInterface guardsmen = treasureRoomMonitor.acquireRead();
      int sum = 0;
      for (int i = 0; i < guardsmen.size(); i++)
      {
        sum += guardsmen.look(i).getValue();
      }

      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      log.log("Value of treasure: " + sum);
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      treasureRoomMonitor.releaseRead();
    }
  }
}
