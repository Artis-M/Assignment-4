public class ValuableTransporter implements Runnable
{
  private int targetValue;
  private int currentValue;
  private Deposit<Valuable> deposit;
  private Logger log;

  public ValuableTransporter(Deposit<Valuable> valuableDepository)
  {
    this.targetValue = Math
        .round(50 + (int) (Math.random() * ((200 - 50) + 1)));
    this.currentValue = 0;
    this.deposit = valuableDepository;
    this.log = Logger.getInstance();
    log.log(targetValue + "");
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

        System.out.println(
            "valuable added" + valuable.getName() + " " + valuable.getValue());
        System.out.println("THE CURRENT VALUE IS " + currentValue);
        System.out.println("THE TARGET VALUE IS " + targetValue);
      }
      else if (currentValue >= targetValue)
      {
        deposit.clear();
        currentValue = 0;
        targetValue = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
        System.out.println("shit delivered");
        i = 0;
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }

  }
}

