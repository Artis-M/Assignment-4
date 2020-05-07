import utility.collection.ArrayList;

public class King implements Runnable
{
    private TreasureRoom<Valuable> treasureRoom;
    private Logger log;

    public King()
    {
        this.treasureRoom = new TreasureRoom<>();
        this.log = Logger.getInstance();
    }

    @Override
    public void run()
    {

        while (true)
        {
            treasureRoom.acquireWrite();
            int random = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
            log.log("\u001B[31m Party goal: " + random + "\u001B[0m");

            int current = 0;
            ArrayList<Valuable> kingpocket = new ArrayList<>();

            for (int i = 0; i < treasureRoom.size(); i++)
            {
                kingpocket.add(treasureRoom.retrieveValuable(i));
                current += kingpocket.get(i).getValue();
                log.log("\u001B[32m Current: " + current + "\u001B[0m");
            }
            if (current >= random)
            {
                System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZz");
                for (int j = 0; j < kingpocket.size(); j++)
                {
                    kingpocket.remove(j);
                }
                log.log("\u001B[33m PARTYYYYYYYYYYY" + "\u001B[0m");

            } else
            {
                for (int j = 0; j < kingpocket.size(); j++)
                {
                    treasureRoom.addValuable(kingpocket.get(j));
                }
                log.log("Party is cancelled, insufficient funds.");
            }
            try
            {
                Thread.sleep(10000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            log.log("DONE");
        }
    }
}
