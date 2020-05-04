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

    @Override
    public void run()
    {
        while (true)
        {
            int random = (int) Math.round(Math.random() * 5);
            switch (random)
            {
                case 1:
                    this.valuable = (Valuable) Mine.getValuable("Diamond");
                case 2:
                    this.valuable = (Valuable) Mine.getValuable("Emerald");
                case 3:
                    this.valuable = (Valuable) Mine.getValuable("Iron");
                case 4:
                    this.valuable = (Valuable) Mine.getValuable("Gold");
            }
            valuableDepository.enqueue(valuable);
            log.log("Miner " + name + " added a " + valuable.getName() + " to the depository.");
            try
            {
                Thread.sleep(5000);
                random = (int) Math.round(Math.random() * 5);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
