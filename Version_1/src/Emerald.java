public class Emerald implements Valuable
{
    private String name;
    private int value;

    public Emerald()
    {
        this.name="Emerald";
        this.value=20;
    }
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getValue()
    {
        return value;
    }
}
