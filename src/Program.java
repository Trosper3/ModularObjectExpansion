import Objects.Commander;

import java.util.Scanner;

public class Program
{
    public static void runProgram()
    {
        Scanner input = new Scanner(System.in);

        Commander me = new Commander(1000);

        while(true)
        {
            switch(Processes.mainMenu())
            {
                case "Build":
                    switch(Processes.buildSelection())
                    {
                        case "Unit":
                            Processes.buildUnit(me);
                            break;
                        case "Hardpoint":
                            Processes.addHardpoint(me, Processes.unitNumSelection(me));
                            break;
                        case "Armament":
                            switch(Processes.objectSelection())
                            {
                                case "Unit":
                                    Processes.addArmament(me, Processes.unitNumSelection(me));
                                    break;
                                case "Hardpoint":
                                    Processes.addArmament(me, Processes.unitNumSelection(me), Processes.hardpointNumSelection(me, Processes.unitNumSelection(me)));
                                    break;
                            }
                            break;
                    }
                    break;

                case "Display":
                    switch(Processes.displaySelection())
                    {
                        case "Fleet":
                            if(me.getFleetSize() == 0)
                                System.out.println("No Fleet To Display");
                            else
                            {
                                Processes.displayFleet(me);
                            }
                        break;
                    }
                    break;
            }
        }
    }
}
