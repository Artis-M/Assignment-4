import utility.collection.ArrayList;

public class King implements Runnable
{
  private TreasureRoomMonitor<Valuable> treasureRoomMonitor;
  private Logger log;

  public King(TreasureRoomMonitor<Valuable> treasureRoomMonitor)
  {
    this.log = Logger.getInstance();
    this.treasureRoomMonitor = treasureRoomMonitor;
  }

  @Override public void run()
  {

    while (true)
    {
      WriterInterface guard = treasureRoomMonitor.acquireWrite();
      int goal = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
      log.log("\u001B[31m Party goal: " + goal + "\u001B[0m");
      int current = 0;

      ArrayList<Valuable> kingPocket = new ArrayList<>();

      while (current < goal && guard.size() != 0)
      {
        kingPocket.add(guard.retrieveValuable());
        current += kingPocket.get(kingPocket.size() - 1).getValue();
      }
      log.log("\u001B[32m Current amount in the king's pocket: " + current + "\u001B[0m");

      if (current >= goal)
      {
        while (!kingPocket.isEmpty())
        {
          kingPocket.remove(kingPocket.size() - 1);
        }
        log.log("\u001B[33m PARTYYYYYYYYYYY" + "\u001B[0m");

      }
      else
      {
        for (int j = 0; j < kingPocket.size(); j++)
        {
          guard.addValuable(kingPocket.get(j));
        }
        log.log("Party is cancelled, insufficient funds.");
      }
      treasureRoomMonitor.releaseWrite();
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
