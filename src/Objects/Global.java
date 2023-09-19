package Objects;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Global
{
    public static ArrayList<Unit> units = new ArrayList<>();
    public static HashMap<Integer,Armament> armaments = new HashMap<>();
    public static HashMap<Integer,Hardpoint> hardpoints = new HashMap<>();
    public static HashMap<String,Commander> commanders = new HashMap<>();
    public static ArrayList<Integer> ids = new ArrayList<>();

    public static void saveUnitBlueprint(Unit unit)
    {
        Global.units.add(unit);
    }

    public static void removeUnitBlueprint(Unit unit)
    {
        units.remove(unit);
        ids.remove(unit.getID());
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
