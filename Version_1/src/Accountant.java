public class Accountant implements Runnable
{
    private TreasureRoom<Valuable> treasureRoom;
    private Logger log;

    public Accountant()
    {
        this.treasureRoom = new TreasureRoom<>();
        this.log = Logger.getInstance();
    }


    @Override
    public void run()
    {
        while (true)
        {
            int sum = 0;
            treasureRoom.acquireRead();
            for (int i = 0; i < treasureRoom.size(); i++)
            {
                sum += treasureRoom.look(i).getValue();
            }

            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            log.log("Value of treasure: " + sum);
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
