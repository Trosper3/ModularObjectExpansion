package Testing;

import Objects.Commander;
import java.sql.*;

public class Processes
{
    public static void displayFleet(Commander commander)
    {
        for (int i = 0; i < commander.getFleetSize(); i++)
        {
            System.out.println(commander.getUnit(i).getName() + ":");
            System.out.println("\tHealth: " + commander.getUnit(i).getHealth());
            System.out.println("\tDamage: " + commander.getUnit(i).getDamage());
            System.out.println("\tSpeed: " + commander.getUnit(i).getSpeed());
            System.out.println();
            System.out.println("\tArmaments:");
            for (int j = 0; j < commander.getUnit(i).getArmamentAmount(); j++)
            {
                System.out.println("\t" + (j + 1) + ") " + commander.getUnit(i).getArmament(j).getName() + ":");
                System.out.println("\t\tHealth: " + commander.getUnit(i).getArmament(j).getHealth());
                System.out.println("\t\tDamage: " + commander.getUnit(i).getArmament(j).getDamage());
                System.out.println("\t\tSpeed: " + commander.getUnit(i).getArmament(j).getSpeed());
            }
            System.out.println();
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

    public static void setData(int id, String name, int health, int damage, int speed) throws SQLException {
        String root = "root"; String password = "Solijan3!";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/units",root,password);
        PreparedStatement st = con.prepareStatement("insert into units values(" + id + "," + "\"" + name + "\"" + "," + health + "," + damage + "," + speed + ");");
        System.out.println("insert into units values(" + id + "," + "\"" + name + "\"" + "," + health + "," + damage + "," + speed + ");");
        st.execute();
        con.close();
    }

    public static String getStat(String parameter, int unit_id) throws SQLException
    {
        String root = "root"; String password = "Solijan3!";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/units",root,password);
        PreparedStatement st = con.prepareStatement("select " + parameter + " from units\n" + "where unit_id = " + unit_id + ";");
        ResultSet r = st.executeQuery();
        if (parameter == "health" || parameter == "damage" || parameter == "speed") {
            while (r.next()) {
                int temp = r.getInt(parameter);
                return Integer.toString(temp);
            }
        }
        else if (parameter == "unit_name") {
            while (r.next()) {
                String temp = r.getString(parameter);
                return temp;
            }
        }
        else
        {
            return null;
        }
        return null;
    }
}
