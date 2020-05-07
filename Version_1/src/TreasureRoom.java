import utility.collection.ArrayList;

public class TreasureRoom<Valuable> implements TreasureRoomDoor<Valuable>
{
    private int readers;
    private int writer;
    private int waitingwriters;
    private ArrayList<Valuable> list;
    private Logger log;

    public TreasureRoom()
    {
        this.readers = 0;
        this.writer = 0;
        this.waitingwriters = 0;
        this.log = Logger.getInstance();
        this.list = new ArrayList<>();
    }

    @Override
    public synchronized void addValuable(Valuable valuable)
    {
        list.add(valuable);
        log.log("Valuable was added to the Treasure Room: " + valuable);
    }

    @Override
    public synchronized Valuable retrieveValuable(int index)
    {
        Valuable valuable = list.get(index);
        list.remove(index);
        return valuable;

    }

    @Override
    public synchronized Valuable look(int index)
    {
        return list.get(index);
    }

    @Override
    public synchronized void acquireRead()
    {
        while (writer > 0 || waitingwriters > 0)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        readers++;
        System.out.println("Reading acquired" + Thread.currentThread().getName());
    }

    @Override
    public synchronized int size()
    {
        return list.size();
    }


    @Override
    public synchronized void acquireWrite()
    {
        waitingwriters++;
        while (readers > 0 || writer > 0)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Writing acquired");
        waitingwriters--;
        writer++;
    }


}
