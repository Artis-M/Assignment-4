public class Gold implements Valuable
{
    private String name;
    private int value;

    public Gold()
    {
        this.name="Gold";
        this.value=2;
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
