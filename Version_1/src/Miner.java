public class Miner<Valuable> implements Runnable
{
    private String name;
    private Valuable valuable;
    private Deposit<Valuable> valuableDepository;

    public Miner(String name, Deposit<Valuable> valuableDepository)
    {
        this.name = name;
        this.valuableDepository = valuableDepository;
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
                    this.valuable = Mine.getValuable("Diamond");
                case 2:
                    this.valuable = Mine.getValuable("Emerald");
                case 3:
                    this.valuable = Mine.getValuable("Iron");
                case 4:
                    this.valuable = Mine.getValuable("Gold");
            }
            valuableDepository.enqueue(valuable);
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
