import Objects.Armament;
import Objects.Commander;
import Objects.Hardpoint;
import Objects.Unit;

import java.util.Scanner;

public class Processes
{
    static Scanner input = new Scanner(System.in);
    public static String mainMenu()
    {
        System.out.print("Enter One of the Following...\nBuild\nDisplay\n\nEntry: ");
        String selection = input.nextLine();
        System.out.println();
        return selection;
    }

    public static void buildUnit(Commander commander)
    {
        System.out.print("Make a Entry Using the Template Shown\n[Name] [Health] [Attack] [Speed]\n\nEntry: ");
        String buildMessage = input.nextLine();
        System.out.println();
        String[] buildComponents = buildMessage.split(" ");
        commander.buildUnit(buildComponents[0],Integer.parseInt(buildComponents[1]),Integer.parseInt(buildComponents[2]),Integer.parseInt(buildComponents[3]));
    }

    public static String buildSelection()
    {
        System.out.print("Make a Entry From the Following...\nUnit\nHardpoint\nArmament\n\nEntry: ");
        String buildMessage = input.nextLine();
        System.out.println();
        return buildMessage;
    }

    public static String displaySelection()
    {
        System.out.print("Make a Entry From the Following...\nFleet\n\nEntry: ");
        String displayMessage = input.nextLine();
        System.out.println();
        return displayMessage;
    }

    public static String objectSelection()
    {
        System.out.print("The Armament Will Be Applied To Which of the Following...\nUnit\nHardpoint\n\nEntry: ");
        String objectMessage = input.nextLine();
        System.out.println();
        return objectMessage;
    }

    public static int unitNumSelection(Commander commander)
    {
        int unitNum = -1;

        if(commander.getFleetSize() == 0)
        {
            System.out.println("No Units");
            return unitNum;
        }

        else
        {
            try
            {
                System.out.print("Enter a Unit Number From 0 To " + (commander.getFleetSize()-1) + " >> ");
                unitNum = input.nextInt();
                System.out.println();
                return unitNum;
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Unit Number Not Available");
                return unitNum;
            }
        }
    }

    public static int hardpointNumSelection(Commander commander, int unitNum)
    {
        int hardpointNum = -1;

        if(commander.getFleetSize() == 0)
        {
            System.out.println("No Units");
            return hardpointNum;
        }

        else
        {
            try
            {
                System.out.print("Enter a Unit Number From 0 To " + commander.getUnit(unitNum).getHardpointAmount() + " >> ");
                hardpointNum = input.nextInt();
                System.out.println();
                return hardpointNum;
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Hardpoint Number Not Available");
                return hardpointNum;
            }
        }
    }

    public static void addHardpoint(Commander commander, int unitNum)
    {
        if(unitNum == -1)
            System.out.println("No Units...Cannot Add Hardpoint");
        else
        {
            System.out.print("Make a Entry Using the Template Shown\n[Name] [Health] [Attack] [Speed]\n\nEntry: ");
            String buildMessage = input.nextLine();
            System.out.println();
            String[] buildComponents = buildMessage.split(" ");
            commander.getUnit(unitNum).addHardpoint(new Hardpoint(buildComponents[0],Integer.parseInt(buildComponents[1]),Integer.parseInt(buildComponents[2]),Integer.parseInt(buildComponents[3])));
        }
    }

    public static void addArmament(Commander commander, int unitNum, int hardpointNum)
    {
        if(unitNum == -1)
            System.out.println("No Units...Cannot Add Armament");
        else
        {
            if(hardpointNum == -1)
                System.out.println("No Hardpoints...Cannot Add Armament");
            else
            {
                System.out.print("Make a Entry Using the Template Shown\n[Name] [Health] [Attack] [Speed]\n\nEntry: ");
                String buildMessage = input.nextLine();
                System.out.println();
                String[] buildComponents = buildMessage.split(" ");
                commander.getUnit(unitNum).getHardpoint(hardpointNum).addArmament(new Armament(buildComponents[0],Integer.parseInt(buildComponents[1]),Integer.parseInt(buildComponents[2]),Integer.parseInt(buildComponents[3])));
            }
        }
    }

    public static void addArmament(Commander commander, int unitNum)
    {
        if(unitNum == -1)
            System.out.println("No Units...Cannot Add Armament");
        else
        {
            if(unitNum == -1)
                System.out.println("No Units...Cannot Add Armament");
            else
            {
                System.out.print("Make a Entry Using the Template Shown\n[Name] [Health] [Attack] [Speed]\n\nEntry: ");
                String buildMessage = input.nextLine();
                System.out.println();
                String[] buildComponents = buildMessage.split(" ");
                commander.getUnit(unitNum).addArmament(new Armament(buildComponents[0],Integer.parseInt(buildComponents[1]),Integer.parseInt(buildComponents[2]),Integer.parseInt(buildComponents[3])));
            }
        }
    }

    public static void displayFleet(Commander commander)
    {
        for (int i = 0; i < commander.getFleetSize(); i++)
        {
            System.out.println(commander.getUnit(i).getName() + ":");
            System.out.println("\tHealth: " + commander.getUnit(i).getHealth());
            System.out.println("\tDamage: " + commander.getUnit(i).getDamage());
            System.out.println("\tSpeed: " + commander.getUnit(i).getSpeed());
            System.out.println("\tArmaments:");
            for (int j = 0; j < commander.getUnit(i).getArmamentAmount(); j++)
            {
                System.out.println("\t" + (j + 1) + ") " + commander.getUnit(i).getArmament(j).getName() + ":");
                System.out.println("\t\tHealth: " + commander.getUnit(i).getArmament(j).getHealth());
                System.out.println("\t\tDamage: " + commander.getUnit(i).getArmament(j).getDamage());
                System.out.println("\t\tSpeed: " + commander.getUnit(i).getArmament(j).getSpeed());
            }
            System.out.println("\tHardpoints:");
            for (int k = 0; k < commander.getUnit(i).getHardpointAmount(); k++)
            {
                System.out.println("\t" + (k + 1) + ") " + commander.getUnit(i).getHardpoint(k).getName() + ":");
                System.out.println("\t\tHealth: " + commander.getUnit(i).getHardpoint(k).getHealth());
                System.out.println("\t\tDamage: " + commander.getUnit(i).getHardpoint(k).getDamage());
                System.out.println("\t\tSpeed: " + commander.getUnit(i).getHardpoint(k).getSpeed());
                System.out.println("\t\tArmaments:");
                for (int l = 0; l < commander.getUnit(i).getHardpoint(k).getArmamentAmount(); l++)
                {
                    System.out.println("\t\t" + (l + 1) + ") " + commander.getUnit(i).getHardpoint(k).getArmament(l).getName() + ":");
                    System.out.println("\t\t\tHealth: " + commander.getUnit(i).getHardpoint(k).getArmament(l).getHealth());
                    System.out.println("\t\t\tDamage: " + commander.getUnit(i).getHardpoint(k).getArmament(l).getDamage());
                    System.out.println("\t\t\tSpeed: " + commander.getUnit(i).getHardpoint(k).getArmament(l).getSpeed());
                }
            }
            System.out.println();
        }
    }
}
