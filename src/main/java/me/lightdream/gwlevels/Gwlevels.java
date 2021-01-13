package me.lightdream.gwlevels;

import me.lightdream.gwlevels.database.DatabaseConnector;
import me.lightdream.gwlevels.events.EntityKillEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Gwlevels extends JavaPlugin {

    private static Gwlevels plugin;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        plugin = this;
        getServer().getConsoleSender().sendMessage("\n" +
                " _____       _             __         _     ______                                           \n" +
                " |_   _|     (_)           [  |       / |_  |_   _ `.                                         \n" +
                "   | |       __     .--./)  | |--.   `| |-'   | | `. \\  _ .--.   .---.   ,--.    _ .--..--.   \n" +
                "   | |   _  [  |   / /'`\\;  | .-. |   | |     | |  | | [ `/'`\\] / /__\\\\ `'_\\ :  [ `.-. .-. |  \n" +
                "  _| |__/ |  | |   \\ \\._//  | | | |   | |,   _| |_.' /  | |     | \\__., // | |,  | | | | | |  \n" +
                " |________| [___]  .',__`  [___]|__]  \\__/  |______.'  [___]     '.__.' \\'-;__/ [___||__||__] \n" +
                "                  ( ( __))                                                                    " +
                "");

        DatabaseConnector.sqlSetup();

        this.getServer().getPluginManager().registerEvents(new EntityKillEvent(), this);

    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
    }

    public static Gwlevels getPlugin(){
        return plugin;
    }

    public static void addPoints(String player, double XP)
    {
        try {
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT COUNT(*) FROM " + DatabaseConnector.levels + " WHERE NAME = '" + player + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNT(*)") == 1) {
                    double currXP = rs.getDouble("XP");
                    st = DatabaseConnector.con.prepareStatement("UPDATE " + DatabaseConnector.levels + " SET XP='" + XP + currXP + "' WHERE NAME='" + player + "'");
                    st.executeUpdate();
                } else {
                    st = DatabaseConnector.con.prepareStatement("INSERT INTO " + DatabaseConnector.levels + " VALUES('" + player + "', '" + XP + "')");
                    st.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
