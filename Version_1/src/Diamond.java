
public class Diamond implements Valuable
{
    private String name;
    private int value;
public Diamond(){
    this.name="Diamond";
    this.value=4;
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
