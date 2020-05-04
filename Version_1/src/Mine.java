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
                if (valuable == null)
                {
                    switch (key)
                    {
                        case "Diamond":
                            valuable = new Diamond();
                        case "Emerald":
                            valuable = new Emerald();
                        case "Gold":
                            valuable = new Gold();
                        case "Iron":
                            valuable = new Iron();
                    }
                    mine.put(key, valuable);
                }
            }

        }

        return valuable;
    }
}
