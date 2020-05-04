public class Iron implements Valuable
{
    private String name;
    private int value;

    public Iron()
    {
        this.name = "Iron";
        this.value = 10;
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
