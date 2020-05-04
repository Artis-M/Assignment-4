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

    @Override
    public void run()
    {
        while (true)
        {
            int random = (int) Math.round(Math.random() * 4);
            System.out.println(random);
            switch (random)
            {
                case 0:
                    this.valuable = Mine.getValuable("Rock");
                    break;
                case 1:
                    this.valuable =  Mine.getValuable("Diamond");
                    break;
                case 2:
                    this.valuable =  Mine.getValuable("Emerald");
                    break;
                case 3:
                    this.valuable =  Mine.getValuable("Iron");
                    break;
                case 4:
                    this.valuable =  Mine.getValuable("Gold");
                    break;
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
