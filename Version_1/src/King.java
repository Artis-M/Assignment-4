import utility.collection.ArrayList;

public class King implements Runnable
{
    private TreasureRoomMonitor<Valuable> treasureRoomMonitor;
    private Logger log;

    public King(TreasureRoomMonitor<Valuable> treasureRoomMonitor)
    {
        this.log = Logger.getInstance();
        this.treasureRoomMonitor = treasureRoomMonitor;
    }

    @Override
    public void run()
    {

        while (true)
        {
            WriterInterface guardsmen = treasureRoomMonitor.acquireWrite();
            int random = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
            log.log("\u001B[31m Party goal: " + random + "\u001B[0m");
            int current = 0;

            ArrayList<Valuable> kingpocket = new ArrayList<>();

            for (int i = 0; i < guardsmen.size(); i++)
            {
                kingpocket.add(guardsmen.retrieveValuable(i));
                current += kingpocket.get(i).getValue();
                System.out.println("CURRENT: " + current);
            }
            System.out.println("THE SIZE IS : " + guardsmen.size());
            log.log("\u001B[32m Current: " + current + "\u001B[0m");
            if (current >= random)
            {
                for (int j = 0; j < kingpocket.size(); j++)
                {
                    kingpocket.remove(j);
                }
                log.log("\u001B[33m PARTYYYYYYYYYYY" + "\u001B[0m");

            } else
            {
                for (int j = 0; j < kingpocket.size(); j++)
                {
                    guardsmen.addValuable(kingpocket.get(j));
                }
                log.log("Party is cancelled, insufficient funds.");
            }
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            treasureRoomMonitor.releaseWrite();
        }
    }
}
