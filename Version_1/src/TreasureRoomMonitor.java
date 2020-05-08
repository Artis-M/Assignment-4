import utility.collection.ArrayList;

public class TreasureRoomMonitor<Valuable> implements TreasureRoomDoor<Valuable>
{
    private int readers;
    private int writer;
    private int waitingwriters;
    private Guardsmen guardsmen;
    private ArrayList<Valuable> list;
    private Logger log;

    public TreasureRoomMonitor(Guardsmen guardsmen)
    {
        this.readers = 0;
        this.writer = 0;
        this.waitingwriters = 0;
        this.log = Logger.getInstance();
        this.list = new ArrayList<>();
        this.guardsmen = guardsmen;
    }

    @Override public synchronized ReaderInterface acquireRead()
    {
        while (waitingwriters > 0 || writer > 0)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
        readers++;
        return guardsmen;
    }

    @Override public synchronized void releaseRead()
    {
        readers--;
        if(readers == 0)
        {
            notify();
        }
    }

    @Override
    public synchronized WriterInterface acquireWrite()
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
        waitingwriters--;
        writer++;
        return guardsmen;
    }

    @Override public synchronized void releaseWrite()
    {
        writer--;
        notifyAll();
    }

}
