package Utility;
import Objects.Object;
import java.security.SecureRandom;

public class AttackChance
{
    public static boolean canAttack(Object attacker, Object target)
    {
        SecureRandom random = new SecureRandom();

        if(attacker.getSpeed() > target.getCost())
            return true;
        else if (attacker.getSpeed() == target.getSpeed())
        {
            int chance = random.nextInt(0,2);
            if(chance == 0)
                return true;
            else
                return false;
        }
        else
        {
            int chance = random.nextInt(0, target.getSpeed());
            if (chance == 0)
                return true;
            else
                return false;
        }
    }
}
