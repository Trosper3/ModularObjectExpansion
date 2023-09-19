package Objects;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Global
{
    public static HashMap<Integer,Unit> units = new HashMap();
    public static HashMap<Integer,Armament> armaments = new HashMap<>();
    public static HashMap<Integer,Hardpoint> hardpoints = new HashMap<>();
    public static HashMap<String,Commander> commanders = new HashMap<>();
    public static ArrayList<Integer> ids = new ArrayList<>();

    public static void removeUnitBlueprint(int id)
    {
        units.remove(id);
        ids.remove(id);
    }

    public static void removeArmamentBlueprint(int id)
    {
        armaments.remove(id);
        ids.remove(id);
    }

    public static void removeHardpointBlueprint(int id)
    {
        hardpoints.remove(id);
        ids.remove(id);
    }
}
