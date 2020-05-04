public class Rock implements Valuable
{
  private String name;
  private int value;

  public Rock()
  {
    this.name = "Rock";
    this.value = 0;
  }

  @Override public String getName()
  {
    return name;
  }

  @Override public int getValue()
  {
    return value;
  }
}
