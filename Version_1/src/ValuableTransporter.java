public class ValuableTransporter implements Runnable
{
    private int targetValue;
    private int currentValue;
    private Deposit<Valuable> deposit;
    private Logger log;
    private TreasureRoom<Valuable> treasureRoom;

    public ValuableTransporter(Deposit<Valuable> valuableDepository)
    {
        this.targetValue = Math
                .round(50 + (int) (Math.random() * ((200 - 50) + 1)));
        this.currentValue = 0;
        this.deposit = valuableDepository;
        this.log = Logger.getInstance();
        log.log(targetValue + "");
        this.treasureRoom = new TreasureRoom<>();
    }

    @Override
    public void run()
    {
        int i = 0;
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
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
                log.log("Valuable added" + valuable.getName() + " " + valuable.getValue());
                log.log("THE CURRENT VALUE IS " + currentValue);
                log.log("THE TARGET VALUE IS " + targetValue);

            } else if (currentValue >= targetValue)
            {
                deposit.clear();
                currentValue = 0;
                targetValue = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));

                for (int j = 0; j < deposit.size(); j++)
                {
                    treasureRoom.addValuable(deposit.dequeue());
                }
               log.log("Valuables delivered");
                i = 0;
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
}

