import java.util.HashMap;
import java.util.Map;

public class Mine
{

  private static Map<String, Valuable> mine = new HashMap<>();

  public static Valuable getValuable(String key)
  {
    Valuable valuable = mine.get(key);
    if (valuable == null)
    {
      synchronized (mine)
      {
        switch (key)
        {
          case "Diamond":
            valuable = new Diamond();
            break;
          case "Emerald":
            valuable = new Emerald();
            break;
          case "Gold":
            valuable = new Gold();
            break;
          case "Iron":
            valuable = new Iron();
            break;
        }
        mine.put(key, valuable);
      }

    }

    return valuable;
  }
}
