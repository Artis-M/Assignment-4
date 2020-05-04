public class Miner
{
    private String name;
    private Valuable valuable;

    public Miner(String name,String key)
    {
        this.name= name;
        this.valuable= Mine.getValuable(key);
    }

    public String getName()
    {
        return name;
    }

    public Valuable getValuable()
    {
        return valuable;
    }
}
