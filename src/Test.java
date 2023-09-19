import Objects.Armament;
import Objects.Commander;
import Objects.Global;
import Objects.Hardpoint;
import Testing.Processes;
import Testing.Program;

public class Test
{
    // Add Increase and Decrease of User.money
    // Globals Are Not Independent of Reference Object
    public static void main(String[] args)
    {
        //Program.runProgram();
        Commander me = new Commander(1000);

        me.buildUnit("Arc Wing",10,0,0);
        me.getUnit(0).addArmament(new Armament("Laser Cannon", 0,10,0));
        me.getUnit(0).addArmament(new Armament("Laser Cannon", 0,10,0));
        me.getUnit(0).addArmament(new Armament("Sublight Engine", 0,0,5));
        me.getUnit(0).addHardpoint(new Hardpoint("Turret", 5));
        me.getUnit(0).getHardpoint(0).addArmament(new Armament("Laser Cannon", 0,10,0));
        me.getUnit(0).getHardpoint(0).addArmament(new Armament("Laser Cannon", 0,10,0));

        me.buildUnit("Droid Star Fighter",5,0,0);
        me.getUnit(1).addArmament(new Armament("Laser Cannon", 0,10,0));
        me.getUnit(1).addArmament(new Armament("Laser Cannon", 0,10,0));
        me.getUnit(1).addArmament(new Armament("Sublight Engine", 0,0,5));

        Processes.displayFleet(me);
    }
}
