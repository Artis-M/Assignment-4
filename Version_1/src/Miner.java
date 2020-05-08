public class Miner implements Runnable
{
  private String name;
  private Valuable valuable;
  private Deposit<Valuable> valuableDepository;
  private Logger log;

  public Miner(String name, Deposit<Valuable> valuableDepository)
  {
    this.name = name;
    this.valuableDepository = valuableDepository;
    this.valuable = null;
    log = Logger.getInstance();
  }

  public String getName()
  {
    return name;
  }

  public Valuable getValuable()
  {
    return valuable;
  }

  @Override public void run()
  {
    while (true)
    {
      int random = (int) Math.round(Math.random() * 4);
      switch (random)
      {
        case 0:
          this.valuable = Mine.getValuable("Diamond");
          valuableDepository.enqueue(valuable);
          break;
        case 1:
          this.valuable = Mine.getValuable("Emerald");
          valuableDepository.enqueue(valuable);
          break;
        case 2:
          this.valuable = Mine.getValuable("Iron");
          valuableDepository.enqueue(valuable);
          break;
        case 3:
          this.valuable = Mine.getValuable("Gold");
          valuableDepository.enqueue(valuable);

          break;
      }
      log.log("Miner " + name + " added a valuable to the depository.");
      try
      {
        Thread.sleep(5000);
        random = (int) Math.round(Math.random() * 5);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
