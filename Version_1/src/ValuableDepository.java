import utility.collection.ArrayList;

public class ValuableDepository<T> implements Deposit<T>
{
    private ArrayList<T> arrayList;
    private int size;
    private Logger log;

    public ValuableDepository(int size)
    {
        arrayList = new ArrayList<>();
        this.size = size;
        log = Logger.getInstance();
    }

    @Override
    public void enqueue(T object)
    {
        if (arrayList.size() < size)
        {
            arrayList.add(object);
        } else
        {
            log.log("ValuableDepository is full.");
        }
    }

    @Override
    public T dequeue()
    {
        if (arrayList.size() > 0)
        {
            return arrayList.remove(arrayList.size());
        } else
        {
            log.log("Empty deposit.");
            return null;
        }
    }

    @Override
    public T getLastValue()
    {
        return arrayList.get(arrayList.size() - 1);
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < arrayList.size(); i++)
        {
            arrayList.remove(i);
        }
    }


}
