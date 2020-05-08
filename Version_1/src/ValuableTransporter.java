public class ValuableTransporter implements Runnable
{
  private int targetValue;
  private int currentValue;
  private Guardsmen guardsmen;
  private Deposit<Valuable> deposit;
  private Logger log;

  public ValuableTransporter(Deposit<Valuable> valuableDepository,
      Guardsmen guardsmen)
  {
    this.targetValue = Math
        .round(50 + (int) (Math.random() * ((200 - 50) + 1)));
    this.currentValue = 0;
    this.deposit = valuableDepository;
    this.log = Logger.getInstance();
    log.log(targetValue + "");
    this.guardsmen = guardsmen;
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

    while (true)
    {
      if (currentValue < targetValue && i < deposit.size())
      {
        Valuable valuable = deposit.getValuableAtIndex(i);
        currentValue += valuable.getValue();
        i++;
        log.log(
            "Valuable added" + valuable.getName() + " " + valuable.getValue());
        log.log("THE CURRENT VALUE IS " + currentValue);
        log.log("THE TARGET VALUE IS " + targetValue);

      }
      else if (currentValue >= targetValue)
      {
        for (int j = 0; j < deposit.size(); j++)
        {
          guardsmen.addValuable(deposit.dequeue(j));
          System.out.println("VALUABLE ADDED TO THE TRES: " + j);
        }
        log.log("The deposit size is " + deposit.size());
        log.log("Valuables delivered");
        i = 0;
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        currentValue = 0;
        targetValue = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
      }
    }

  }
}

