public class ValuableTransporter implements Runnable
{
  private int targetValue;
  private int currentValue;
  private TreasureRoomMonitor<Valuable> treasureRoomMonitor;
  private Deposit<Valuable> deposit;
  private Logger log;

  public ValuableTransporter(Deposit<Valuable> valuableDepository,
      TreasureRoomMonitor<Valuable> treasureRoomMonitor)
  {
    this.targetValue = Math
        .round(50 + (int) (Math.random() * ((200 - 50) + 1)));
    this.currentValue = 0;
    this.deposit = valuableDepository;
    this.log = Logger.getInstance();
    log.log(targetValue + "");
    this.treasureRoomMonitor = treasureRoomMonitor;
  }

  @Override public void run()
  {
    int i = 0;
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    log.log("The target value is " + targetValue);
    while (true)
    {
      if (currentValue < targetValue && i < deposit.size())
      {
        Valuable valuable = deposit.getValuableAtIndex(i);
        currentValue += valuable.getValue();
        i++;
        log.log(
            "Valuable added" + valuable.getName() + " " + valuable.getValue());
        log.log("The current value is " + currentValue);
      }
      else if (currentValue >= targetValue)
      {
        WriterInterface guard = treasureRoomMonitor.acquireWrite();
        while (!deposit.isEmpty())
        {
          log.log("Valuable has been delivered: " + deposit.getLastValue().getName());
          guard.addValuable(deposit.dequeue());
        }
        treasureRoomMonitor.releaseWrite();
        log.log("Valuables delivered");
        i = 0;
        currentValue = 0;
        targetValue = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        log.log("The target value is " + targetValue);
      }
    }

  }
}

