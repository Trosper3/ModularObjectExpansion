package Utility;

import Objects.Global;

import java.security.SecureRandom;

public class ID
{
    public static int assignID()
    {
        SecureRandom random = new SecureRandom();

        boolean hasUniqueID = false;
        int id = 0;

        while (hasUniqueID == false)
        {
            id = random.nextInt(1, 1000);
            if (Global.ids.contains(id))
                hasUniqueID = false;
            else
            {
                hasUniqueID = true;
                Global.ids.add(id);
            }
        }
            return id;
    }
}
