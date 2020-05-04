public class ValuableTransporter implements Runnable
{
    private int targetValue;
    private int currentValue;
    private Deposit deposit;
    private Logger log;

    public ValuableTransporter()
    {
        this.targetValue = 50 + (int) (Math.random() * ((200 - 50) + 1));
        this.currentValue = 0;
        this.deposit = new ValuableDepository(200);
        this.log = Logger.getInstance();
    }

    @Override
    public void run()
    {
        while (true)
        {
            while (targetValue <= currentValue)
            {
                Valuable valuable = (Valuable) deposit.getLastValue();
                currentValue += valuable.getValue();
                log.log("Added: " + valuable.getName());

            }
            log.log("Delivered valuables with the total value of: " + currentValue + "\n The transposrter has gone on a break");
            deposit.clear();
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
