package me.lightdream.gwlevels;

import me.lightdream.gwlevels.commands.CommandManager;
import me.lightdream.gwlevels.database.DatabaseConnector;
import me.lightdream.gwlevels.events.EntityKillEvent;
import me.lightdream.gwlevels.events.InventoryClickEvent;
import me.lightdream.gwlevels.exceptions.NoUserFound;
import me.lightdream.gwlevels.expansions.PAPI;
import me.lightdream.gwlevels.items.ItemsInit;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Gwlevels extends JavaPlugin {

    private static Gwlevels plugin;

    public static final List<Integer> levelInv_lightBluePane = Arrays.asList(0,1,2,3,4,5,6,7,8,9,17,18,19,25,26,27,28,34,35);
    public static final List<Integer> levelInv_yellowPane = Arrays.asList(36,37,38,39,40,41,42,43,44,45,53);
    public static final List<Integer> levelInv_levelSlots = Arrays.asList(10,11,12,13,14,15,16,20,21,22,23,24,30,31,32);

    public static final List<List<String>> rewards = Arrays.<List<String>>asList(
            Arrays.asList("&710 Diamante", "give %player_name% Diamond 10"),
            Arrays.asList("&7O sabie de diamant", "give %player_name% recompensa2 Diamond_Sword 1"),
            Arrays.asList("&7Un topor de diamant", "give %player_name% Diamond_axe 1"),
            Arrays.asList("&7Un tarnacop de diamant", "give %player_name% Diamond_Pickaxe 1"),
            Arrays.asList("&7O lopata de diamant", "give %player_name% diamond_shovel 1"),
            Arrays.asList("&75.000 de bani", "give %player_name% Diamond 1|eco give %player_name% 5000 "),
            Arrays.asList("&7Mancare delicioasa", "give %player_name% Potato 32"),
            Arrays.asList("&710.000 de bani", "eco give %player_name% 10000 "),
            Arrays.asList("&7Arc si sageti", "give %player_name% Bow 1|give %player_name% Arrow 64"),
            Arrays.asList("&7Armura de diamant", "give %player_name% Diamond_Helmet 1 |give %player_name% Diamond_Chestplate 1|give %player_name% Diamond_Leggings 1|give %player_name% Diamond_Boots 1"),
            Arrays.asList("&712 blocks de Obsidian", "give %player_name% Obsidian 12"),
            Arrays.asList("&7O carte magica", "give %player_name% mending_book 1"),
            Arrays.asList("&75.000 de bani", "eco give %player_name% 15000"),
            Arrays.asList("&7Mere de aur", "give %player_name% Golden_apple 64"),
            Arrays.asList("&7Lemne de construit", "give %player_name% Dark_Oak_log 32"),
            Arrays.asList("&720.000 de bani", "eco give %player_name% 20000"),
            Arrays.asList("&7Sabie de Netherite", "give %player_name% Netherite_Sword"),
            Arrays.asList("&71 spawner de villigers", "ss give %player_name% villiger 1 "),
            Arrays.asList("&725000 de bani", "eco give %player_name% 25000"),
            Arrays.asList("&71 stack de stone", "give %player_name% Stone 64"),
            Arrays.asList("&715 bucati de aur", "give %player_name% Gold 15"),
            Arrays.asList("&730.000 de bani", "eco give %player_name% 30000 "),
            Arrays.asList("&72 zombie spawners", "give %player_name% zombie 2"),
            Arrays.asList("&7Tarnacop de netherite", "give %player_name% Netherite_Pickaxe 1"),
            Arrays.asList("&71 stack de iron", "eco give %player_name% Iron 64"),
            Arrays.asList("&75 Block-uri de protectie si 10.00 de bani", "eco give %player_name% 10000 |ps give 57 %player_name% 5"),
            Arrays.asList("&71 Spider spawner ", "ss give %player_name% Spider 1 "),
            Arrays.asList("&7Capul tau,30000 de bani si un topor de Netherite", "eco give %player_name% 30000|skull %player_name%|give %player_name% Netherite_axe 1"),
            Arrays.asList("&71 stack de coal", "give %player_name% coal 64"),
            Arrays.asList("&7Nether portal kit", "give %player_name% Obsidian 12|give %player_name% filnt_&_steel|give %player_name% Diamond_pickaxe 1 "),
            Arrays.asList("&71 stack mere de aur", "give %player_name% Golden_apple 64"),
            Arrays.asList("&71 Spawner de papagali", "ss give %player_name% parrot 1"),
            Arrays.asList("&720 de emeralde", "eco give %player_name% Emerald 20"),
            Arrays.asList("&71 stack de lemn si 10.000 de bani", "eco give %player_name% Spruce_wood 64|eco give %player_name% 10000"),
            Arrays.asList("&71 Spawner de Iron golem", "ss give %player_name% Iron_Golem 1"),
            Arrays.asList("&720.000 de bani si 32 mere de aur", "eco give %player_name% 20000|give %player_name% golden_apple 32"),
            Arrays.asList("&72 villagers spawners", "ss give %player_name% villager 2"),
            Arrays.asList("&732 bucati de Conduit", "give %player_name% Conduit 32"),
            Arrays.asList("&740.000 de bani", "eco give %player_name% 40000 "),
            Arrays.asList("&725 diamante si 10 mere de aur", "give %player_name% Diamond 25|give %player_name% golden_apple 10"),
            Arrays.asList("&71Blockuri de dmd 3 bucati", "give %player_name% diamond_block 3"),
            Arrays.asList("&7Xp bottles", "give %player_name% experience_bottle 20"),
            Arrays.asList("&7Blockuri de iron 10 bucati", "give %player_name% iron_block 10"),
            Arrays.asList("&7Ai castigat iteme de construit", "give %player_name% glowstone 64|give %player_name% stone_brick 64|give %player_name% spruce_log 64"),
            Arrays.asList("&7Mere de aur 5 bucati", "give %player_name% golden_apple 5"),
            Arrays.asList("&7Blockuri de gold 5 bucati", "give %player_name% gold_block 5"),
            Arrays.asList("&7Iron blocks 10 bucati", "give %player_name% iron_block 10"),
            Arrays.asList("&7Ancient debris 1 bucata", "give %player_name% ancient_debris 1"),
            Arrays.asList("&7Armura de netherite", "give %player_name% netherite_chestplate 1"),
            Arrays.asList("&7Blockuri de dmd", "give %player_name% diamond_block 5"),
            Arrays.asList("&764 Block de carbuni ", "give %player_name% coal_block 64"),
            Arrays.asList("&7Jumate stack Block de gold", "give %player_name% gold_block 32"),
            Arrays.asList("&7Un conduit", "give %player_name% Conduit 1"),
            Arrays.asList("&7Jumate stack de obsidian", "give %player_name% Obsidian 32"),
            Arrays.asList("&7Blockuri de iron si 20k ", "give %player_name% Iron_block 20|eco give %player_name% 20000"),
            Arrays.asList("&7Spawn egg de villager", "give %player_name% Villager_spawn_egg 1"),
            Arrays.asList("&7Oua de testoasa", "give %player_name% turtle_egg 10"),
            Arrays.asList("&7Ai castigat 40k", "eco give %player_name% 40000"),
            Arrays.asList("&7Xp bottles", "give %player_name% Experience_bottle 64"),
            Arrays.asList("&7Un beacon", "give %player_name% Beacon 1"),
            Arrays.asList("&7Un stack de blockuri de gold", "give %player_name% gold_block 64"),
            Arrays.asList("&7Un stack de blockuri de gold", "give %player_name% gold_block 64"),
            Arrays.asList("&7Mere de aur", "give %player_name% golden_apple 15"),
            Arrays.asList("&7Un stack de morcovi de aur", "give %player_name% golden_carrot 64"),
            Arrays.asList("&7Ancient Debris", "give %player_name% ancient_debriis 4"),
            Arrays.asList("&71Un notch apple", "give %player_name% enchanted_golden_apple 1"),
            Arrays.asList("&7Un stack de slime blockuri ", "give %player_name% slime_block 64"),
            Arrays.asList("&770k", "eco give %player_name% 70000"),
            Arrays.asList("&7Spawn egg de villageri", "give %player_name% villager_spawn_egg 4"),
            Arrays.asList("&7Sticlute cu xp", "give %player_name% experience _bottle 69"),
            Arrays.asList("&7Un stack de obsidian", "give %player_name% Obsidian 64"),
            Arrays.asList("&7Jumate de stack de mere de aur si 20k", "give %player_name% golden_apple 32|eco give %player_name% 20000"),
            Arrays.asList("&7Notch apples 5", "give %player_name% enchanted_golden_apple 5"),
            Arrays.asList("&7Un stack de glistering melon", "give %player_name% glistering_melon 64"),
            Arrays.asList("&7End crystals 10 bucati", "give %player_name% end_crystal 10"),
            Arrays.asList("&7Ai castigat 90k", "eco give %player_name% 90000"),
            Arrays.asList("&7Ai castigat 15 blockuri de diamant", "give %player_name% diamond_block 15"),
            Arrays.asList("&7Un stack de iron block", "give %player_name% iron_block 64"),
            Arrays.asList("&7Mere de aur si 30k", "give %player_name% golden_apple 32|eco give %player_name% 30000"),
            Arrays.asList("&7Notch apples 10 bucati", "give %player_name% enchanted_golden_apple 10 "),
            Arrays.asList("&7Xp bottles 90 bucati", "give %player_name% experience_bottle 90"),
            Arrays.asList("&7Un netherite", "give %player_name% netherite 1"),
            Arrays.asList("&7Nether stars 3 bucati", "give %player_name% nether_star 3"),
            Arrays.asList("&7Capete de wither scheleton 3 bucati", "give %player_name% wither_skeleton_skull 3"),
            Arrays.asList("&7Ai castigat 100k+ 4 mere de aur", "give %player_name% golden_apple|eco give %player_name% 100000"),
            Arrays.asList("&7O sabie de netherite", "give %player_name% netherite_sword 1"),
            Arrays.asList("&7Notch apples 12 bucati", "give %player_name% enchanted_golden_apple 12"),
            Arrays.asList("&7Netherite 3 bucati", "give %player_name% netherite 3"),
            Arrays.asList("&7Ai castiagt 25 de blockuri de dmd", "give %player_name% diamond_block 25"),
            Arrays.asList("&7Ai castigat 130k", "eco give %player_name% 130000"),
            Arrays.asList("&7Nether star 5 bucati", "give %player_name% nether_star 5"),
            Arrays.asList("&7Beacons 3 bucati", "give %player_name% beacon 3"),
            Arrays.asList("&7Ai castigat 150k", "eco give %player_name% 150000"),
            Arrays.asList("&7Notch apples 20 bucati", "give %player_name% enchanted_golden_apple 20"),
            Arrays.asList("&7Capete de wither scheleton 9 bucati", "give %player_name% wither_skeleton_skull 9"),
            Arrays.asList("&7Blockuri de nether ite 10 bucati ", "give %player_name% netherite_block 10"),
            Arrays.asList("&7Notch apples 32 bucati", "give %player_name% enchanted_golden_apple 32"),
            Arrays.asList("&7Ai castiagt 200k", "eco give %player_name% 200000"),
            Arrays.asList("&7Un stack jumate de dmd block", "give %player_name% diamond_block 96"),
            Arrays.asList("&7Un stack de notch apples+50k", "give %player_name% enchanted_golden_apple 64|eco give %player_name% 50000")
    );

    public static NamespacedKey rewardKey;
    public static NamespacedKey nextKey;
    public static NamespacedKey backKey;

    @Override
    public void onEnable() {
        plugin = this;

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPI().register();
        } else {

            System.out.println("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);

        rewardKey = new NamespacedKey(plugin,"claim");
        nextKey = new NamespacedKey(plugin,"next");
        backKey = new NamespacedKey(plugin,"back");

        getServer().getConsoleSender().sendMessage("  _____       _             __         _     ______                                           \n |_   _|     (_)           [  |       / |_  |_   _ `.                                         \n   | |       __     .--./)  | |--.   `| |-'   | | `. \\  _ .--.   .---.   ,--.    _ .--..--.   \n   | |   _  [  |   / /'`\\;  | .-. |   | |     | |  | | [ `/'`\\] / /__\\\\ `'_\\ :  [ `.-. .-. |  \n  _| |__/ |  | |   \\ \\._//  | | | |   | |,   _| |_.' /  | |     | \\__., // | |,  | | | | | |  \n |________| [___]  .',__`  [___]|__]  \\__/  |______.'  [___]     '.__.' \\'-;__/ [___||__||__] \n                  ( ( __))                                                                    ");

        DatabaseConnector.sqlSetup();

        this.getServer().getPluginManager().registerEvents(new EntityKillEvent(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClickEvent(), this);

        Objects.requireNonNull(this.getCommand("calculate")).setExecutor(new CommandManager());
        Objects.requireNonNull(this.getCommand("level")).setExecutor(new CommandManager());
        Objects.requireNonNull(this.getCommand("dev")).setExecutor(new CommandManager());
        Objects.requireNonNull(this.getCommand("admin")).setExecutor(new CommandManager());

    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
    }





    // ------------------------------ Getters ------------------------------
    public static Inventory getLevelInventory(Player player, int page)
    {
        if(page <= 6 && page >= 0)
        {
            Inventory levelInv = Bukkit.createInventory(null, 54, "Level");
            char[] data = Gwlevels.getClaimed(player.getName());

            for(int i : levelInv_lightBluePane)
                levelInv.setItem(i, ItemsInit.getLightBluePane());
            for(int i : levelInv_yellowPane)
                levelInv.setItem(i, ItemsInit.getYellowPane());
            for(int i=0;i<Math.min(levelInv_levelSlots.size(), data.length - page * 15);i++)
            {
                if(data[i + 15 * page] == '1')
                    levelInv.setItem(levelInv_levelSlots.get(i), ItemsInit.getLevelRewardClaimed("&b&lLevel &e" + (i + 1 + page * 15), i + page * 15));
                else
                    levelInv.setItem(levelInv_levelSlots.get(i), ItemsInit.getLevelRewardUnclaimed("&b&lLevel &e" + (i + 1 + page * 15), i + page * 15));
            }

            if(page == 0)
            {
                ItemStack next = ItemsInit.getHead("arrowRight");
                ItemMeta meta = next.getItemMeta();
                meta.getPersistentDataContainer().set(Gwlevels.nextKey, PersistentDataType.STRING, "next");
                next.setItemMeta(meta);
                levelInv.setItem(33, next);
                levelInv.setItem(29, ItemsInit.getBarrier());
            }
            else if (page == 6)
            {
                ItemStack back = ItemsInit.getHead("arrowLeft");
                ItemMeta meta = back.getItemMeta();
                meta.getPersistentDataContainer().set(Gwlevels.backKey, PersistentDataType.STRING, "back");
                back.setItemMeta(meta);
                levelInv.setItem(29, back);
                levelInv.setItem(33, ItemsInit.getBarrier());
            }
            else
            {
                ItemStack back = ItemsInit.getHead("arrowLeft");
                ItemMeta meta = back.getItemMeta();
                meta.getPersistentDataContainer().set(Gwlevels.backKey, PersistentDataType.STRING, "back");
                back.setItemMeta(meta);
                levelInv.setItem(29, back);

                ItemStack next = ItemsInit.getHead("arrowRight");
                meta = next.getItemMeta();
                meta.getPersistentDataContainer().set(Gwlevels.nextKey, PersistentDataType.STRING, "next");
                next.setItemMeta(meta);
                levelInv.setItem(33, next);
            }
            return levelInv;
        }
        return null;
    }

    public static String getLevelFormated(String player)
    {
        String icon = "█";
        String output = "";

        for(int i=0;i<(int)Math.floor(10 * (getXP(player) - getXP((int)Math.floor(getLevel(player)))) / (getXP(1 + (int)Math.floor(getLevel(player))) - getXP((int)Math.floor(getLevel(player)))));i++)
            output += "&b" + icon;
        for(int i=(int)Math.floor(10 * (getXP(player) - getXP((int)Math.floor(getLevel(player)))) / (getXP(1 + (int)Math.floor(getLevel(player))) - getXP((int)Math.floor(getLevel(player)))))+1;i<=10;i++)
            output += "&7" + icon;
        return output;
    }

    public static String getLevelPercent(String player)
    {
        return (int) Math.floor(10000 * (getXP(player) - getXP((int) Math.floor(getLevel(player)))) / (getXP(1 + (int) Math.floor(getLevel(player))) - getXP((int) Math.floor(getLevel(player))))) / 100.0 + "%";
    }

    public static Gwlevels getPlugin(){
        return plugin;
    }




    // ------------------------------ Database OPS ------------------------------
    //Level
    public static void setLevel (String player, int level) throws NoUserFound
    {
        try {
            double XP = (int)Math.ceil(getXP(level)) + 1;
            setXP(player, XP);

        } catch (NoUserFound e) {
            throw new NoUserFound("This user does not exist");
        }
    }

    public static void addLevel (String player, int level) throws NoUserFound
    {
        try {
            double XP = (int)Math.ceil(getXP(level)) + 1 + getXP(player);
            setXP(player, XP);

        } catch (NoUserFound e) {
            throw new NoUserFound("This user does not exist");
        }
    }

    public static double getLevel(double xp)
    {
        if(xp == 0)
            return 0;
        return log((13 * xp + 1599)/ (13000 - 1000 * Math.pow(130, 1.0/2.0)), 13.0/10.0);
    }

    public static double getLevel(String player)
    {
        return getLevel(getXP(player));
    }


    //XP
    public static void addXP(String player, double XP)
    {
        try {
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT COUNT(*) FROM " + DatabaseConnector.levels + " WHERE NAME = '" + player + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNT(*)") == 1) {
                    XP += getXP(player);
                    st = DatabaseConnector.con.prepareStatement("UPDATE " + DatabaseConnector.levels + " SET XP='" + XP + "' WHERE NAME='" + player + "'");
                } else {
                    System.out.println("INSERT INTO " + DatabaseConnector.levels + " VALUES('" + player + "', '" + XP + "', '0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000')");
                    st = DatabaseConnector.con.prepareStatement("INSERT INTO " + DatabaseConnector.levels + " VALUES('" + player + "', '" + XP + "', '0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000')");
                }
                st.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setXP(String player, double XP) throws NoUserFound
    {
        try {
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT COUNT(*) FROM " + DatabaseConnector.levels + " WHERE NAME = '" + player + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNT(*)") == 1) {
                    st = DatabaseConnector.con.prepareStatement("UPDATE " + DatabaseConnector.levels + " SET XP='" + XP + "' WHERE NAME='" + player + "'");
                } else {
                    System.out.println("INSERT INTO " + DatabaseConnector.levels + " VALUES('" + player + "', '" + XP + "', '0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000')");
                    st = DatabaseConnector.con.prepareStatement("INSERT INTO " + DatabaseConnector.levels + " VALUES('" + player + "', '" + XP + "', '0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000')");
                }
                st.executeUpdate();
            }
        } catch (SQLException e) {
            throw new NoUserFound("This user does not exist");
        }
    }

    public static double getXP(String player)
    {
        try {
            double XP = 0;
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT XP FROM " + DatabaseConnector.levels + " WHERE NAME = '" + player + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                XP = rs.getDouble("XP");
            }
            return XP;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static double getXP(int level)
    {
        if(level == 0)
            return 0;
        return 1000 * (Math.pow(1.3, level) - Math.pow(1.3, level-0.5)) - 123;

    }

    //Data
    public static void setClaimed(String player, char[] data)
    {
        //System.out.println(data);
        //System.out.println(new String(data));
        try {
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT COUNT(*) FROM " + DatabaseConnector.levels + " WHERE NAME = '" + player + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNT(*)") == 1)
                    st = DatabaseConnector.con.prepareStatement("UPDATE " + DatabaseConnector.levels + " SET CLAIMED='" + new String(data) + "' WHERE NAME='" + player + "'");
            }
            //System.out.println("UPDATE " + DatabaseConnector.levels + " SET CLAIMED='" + data + "' WHERE NAME='" + player + "'");
            st.executeUpdate();
        } catch (SQLException e) {
            throw new NoUserFound("This user does not exist");
        }
    }

    public static char[] getClaimed(String player)
    {
        try {
            String str = "";
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT CLAIMED FROM " + DatabaseConnector.levels + " WHERE NAME = '" + player + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next())
                return rs.getString("CLAIMED").toCharArray();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }





    // ------------------------------ Calculus ------------------------------
    public static double log(double a, double b)
    {
        return Math.log(a) / Math.log(b);
    }




}
