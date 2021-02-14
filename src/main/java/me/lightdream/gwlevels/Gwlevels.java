package me.lightdream.gwlevels;

import me.lightdream.gwlevels.events.EntityKillEvent;
import me.lightdream.gwlevels.events.InventoryClickEvent;
import me.lightdream.gwlevels.events.PlayerJoinEvent;
import me.lightdream.gwlevels.exceptions.NoUserFound;
import me.lightdream.gwlevels.expansions.PAPI;
import me.lightdream.gwlevels.items.ItemsInit;
import me.lightdream.gwlevels.managers.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;


public final class Gwlevels extends JavaPlugin {

    public static final List<List<String>> rewards = Arrays.<List<String>>asList(
            /*01*/Arrays.asList("&7 10x Diamond", "give %player_name% Diamond 10"),
            /*02*/Arrays.asList("&7 1x Diamond Sword", "give %player_name% Diamond_Sword 1"),
            /*03*/Arrays.asList("&7 1x Diamond Axe", "give %player_name% Diamond_axe 1"),
            /*04*/Arrays.asList("&7 1x Diamond Pickaxe", "give %player_name% Diamond_Pickaxe 1"),
            /*05*/Arrays.asList("&7 1x Diamond Shovel", "give %player_name% diamond_shovel 1"),
            /*06*/Arrays.asList("&7 5k", "eco give %player_name% 5000 "),
            /*07*/Arrays.asList("&7 Food", "give %player_name% baked_potato 32"),
            /*08*/Arrays.asList("&7 10k", "eco give %player_name% 10000 "),
            /*09*/Arrays.asList("&7 1x Bow %newline%&764x Arrow", "give %player_name% Bow 1|give %player_name% Arrow 64"),
            /*10*/Arrays.asList("&7 1x Diamond Armour Set", "give %player_name% Diamond_Helmet 1 |give %player_name% Diamond_Chestplate 1|give %player_name% Diamond_Leggings 1|give %player_name% Diamond_Boots 1"),
            /*11*/Arrays.asList("&7 12x Obsidian", "give %player_name% Obsidian 12"),
            /*12*/Arrays.asList("&7 20k", "eco give %player_name% 20000"),
            /*13*/Arrays.asList("&7 5k", "eco give %player_name% 15000"),
            /*14*/Arrays.asList("&7 64x Gapples", "give %player_name% Golden_apple 64"),
            /*15*/Arrays.asList("&7 32x Logs", "give %player_name% Dark_Oak_log 32"),
            /*16*/Arrays.asList("&7 20k", "eco give %player_name% 20000"),
            /*17*/Arrays.asList("&7 1x Netherite Sword", "give %player_name% Netherite_Sword 1"),
            /*18*/Arrays.asList("&7 1x Villager Spawner", "ss give %player_name% villiger 1 "),
            /*19*/Arrays.asList("&7 25k", "eco give %player_name% 25000"),
            /*20*/Arrays.asList("&7 64x Stone", "give %player_name% Stone 64"),
            /*21*/Arrays.asList("&7 15x Gold Ingot", "give %player_name% Gold_ingot 15"),
            /*22*/Arrays.asList("&7 30k", "eco give %player_name% 30000 "),
            /*23*/Arrays.asList("&7 2x Xombie Spawners", "give %player_name% zombie 2"),
            /*24*/Arrays.asList("&7 1x Netherite Pickaxe", "give %player_name% Netherite_Pickaxe 1"),
            /*25*/Arrays.asList("&7 64x Iron Ingot", "eco give %player_name% Iron_ingot 64"),
            /*26*/Arrays.asList("&7 5x Diamond Block %newline%&710k", "eco give %player_name% 10000|give %player_name% diamond_block 5"),
            /*27*/Arrays.asList("&7 1x Spider Spawner ", "ss give %player_name% Spider 1 "),
            /*28*/Arrays.asList("&7 1x Your head %newline%30k %newline%1x Netherite Pickaxe", "eco give %player_name% 30000|skull %player_name%|give %player_name% Netherite_axe 1"),
            /*29*/Arrays.asList("&7 1x Coal", "give %player_name% coal 64"),
            /*30*/Arrays.asList("&7 1x Nether Portla Kit", "give %player_name% Obsidian 12|give %player_name% filnt_&_steel|give %player_name% Diamond_pickaxe 1 "),
            /*31*/Arrays.asList("&7 64x Gapples", "give %player_name% Golden_apple 64"),
            /*32*/Arrays.asList("&7 1x Parrot Spawner", "ss give %player_name% parrot 1"),
            /*33*/Arrays.asList("&7 20x Emeralds", "give %player_name% Emerald 20"),
            /*34*/Arrays.asList("&7 64x Logs %newline%&710k", "give %player_name% Spruce_wood 64|eco give %player_name% 10000"),
            /*35*/Arrays.asList("&7 1x Iron Golem Spawner", "ss give %player_name% Iron_Golem 1"),
            /*36*/Arrays.asList("&7 20k %newline%32x Gapples", "eco give %player_name% 20000|give %player_name% golden_apple 32"),
            /*37*/Arrays.asList("&7 2x Villager Spawner", "ss give %player_name% villager 2"),
            /*38*/Arrays.asList("&7 32x Conduit", "give %player_name% Conduit 32"),
            /*39*/Arrays.asList("&7 40k", "eco give %player_name% 40000 "),
            /*40*/Arrays.asList("&7 25x Diamonds %newline%&710x Gapples", "give %player_name% Diamond 25|give %player_name% golden_apple 10"),
            /*41*/Arrays.asList("&7 3x Diamond Block", "give %player_name% diamond_block 3"),
            /*42*/Arrays.asList("&7 20x XP bottles", "give %player_name% experience_bottle 20"),
            /*43*/Arrays.asList("&7 10x Iron Blocks", "give %player_name% iron_block 10"),
            /*44*/Arrays.asList("&7 Build Items", "give %player_name% glowstone 64|give %player_name% stone_brick 64|give %player_name% spruce_log 64"),
            /*45*/Arrays.asList("&7 5x Gapples", "give %player_name% golden_apple 5"),
            /*46*/Arrays.asList("&7 5x Gold Blocks", "give %player_name% gold_block 5"),
            /*47*/Arrays.asList("&7 10x Iron blocks", "give %player_name% iron_block 10"),
            /*48*/Arrays.asList("&7 1x Ancient Debris", "give %player_name% ancient_debris 1"),
            /*49*/Arrays.asList("&7 1x Netherite Chestplate", "give %player_name% netherite_chestplate 1"),
            /*50*/Arrays.asList("&7 5x Diamond Block", "give %player_name% diamond_block 5"),
            /*51*/Arrays.asList("&7 64x Coal Block", "give %player_name% coal_block 64"),
            /*52*/Arrays.asList("&7 32x Gold Block", "give %player_name% gold_block 32"),
            /*53*/Arrays.asList("&7 1x Conduit", "give %player_name% Conduit 1"),
            /*54*/Arrays.asList("&7 32x Obsidian", "give %player_name% Obsidian 32"),
            /*55*/Arrays.asList("&7 20x IronBlock %newline%&720k", "give %player_name% Iron_block 20|eco give %player_name% 20000"),
            /*56*/Arrays.asList("&7 1x Villager Spawn Egg", "give %player_name% Villager_spawn_egg 1"),
            /*57*/Arrays.asList("&7 10x Turtle egg", "give %player_name% turtle_egg 10"),
            /*58*/Arrays.asList("&7 40k", "eco give %player_name% 40000"),
            /*59*/Arrays.asList("&7 64x XP bottles", "give %player_name% Experience_bottle 64"),
            /*60*/Arrays.asList("&7 1x Beacon", "give %player_name% Beacon 1"),
            /*61*/Arrays.asList("&7 64x Gold Blocks", "give %player_name% gold_block 64"),
            /*62*/Arrays.asList("&7 64x Gold Blocks", "give %player_name% gold_block 64"),
            /*63*/Arrays.asList("&7 16x Golden Apples", "give %player_name% golden_apple 16"),
            /*64*/Arrays.asList("&7 64x Golden Carrots", "give %player_name% golden_carrot 64"),
            /*65*/Arrays.asList("&7 4x Ancient Debris", "give %player_name% ancient_debris 4"),
            /*66*/Arrays.asList("&7 1x Notch apple", "give %player_name% enchanted_golden_apple 1"),
            /*67*/Arrays.asList("&7 64x Slime Blocks", "give %player_name% slime_block 64"),
            /*68*/Arrays.asList("&7 70k", "eco give %player_name% 70000"),
            /*69*/Arrays.asList("&7 1x Villager Spawn Egg", "give %player_name% villager_spawn_egg 4"),
            /*70*/Arrays.asList("&7 64x XP Bottles", "give %player_name% experience_bottle 64"),
            /*71*/Arrays.asList("&7 64x Obsidian", "give %player_name% Obsidian 64"),
            /*72*/Arrays.asList("&7 32x Golden Apple %newline%&720k", "give %player_name% golden_apple 32|eco give %player_name% 20000"),
            /*73*/Arrays.asList("&7 5x Notch Apple", "give %player_name% enchanted_golden_apple 5"),
            /*74*/Arrays.asList("&7 64x Glistering Melon", "give %player_name% glistering_melon 64"),
            /*75*/Arrays.asList("&7 10x End Crystal", "give %player_name% end_crystal 10"),
            /*76*/Arrays.asList("&7 90k", "eco give %player_name% 90000"),
            /*77*/Arrays.asList("&7 16x Diamond Block", "give %player_name% diamond_block 16"),
            /*78*/Arrays.asList("&7 64x Iron Block", "give %player_name% iron_block 64"),
            /*79*/Arrays.asList("&7 32x Golden Apple %newline%&730k", "give %player_name% golden_apple 32|eco give %player_name% 30000"),
            /*80*/Arrays.asList("&7 10x Notch Apple", "give %player_name% enchanted_golden_apple 10 "),
            /*81*/Arrays.asList("&7 90x XP Bottle", "give %player_name% experience_bottle 90"),
            /*82*/Arrays.asList("&7 1x Netherite Ingot", "give %player_name% netherite_ingot 1"),
            /*83*/Arrays.asList("&7 3x Nether Star", "give %player_name% nether_star 3"),
            /*84*/Arrays.asList("&7 3x Wither Scheleton Head", "give %player_name% wither_skeleton_skull 3"),
            /*85*/Arrays.asList("&7 100k %newline%&74xGolden Apple", "give %player_name% golden_apple|eco give %player_name% 100000"),
            /*86*/Arrays.asList("&7 1xNetherite Sword", "give %player_name% netherite_sword 1"),
            /*87*/Arrays.asList("&7 12x Notch Apple", "give %player_name% enchanted_golden_apple 12"),
            /*88*/Arrays.asList("&7 3x Netherite Ingot", "give %player_name% netherite_ingot 3"),
            /*89*/Arrays.asList("&7 25x Diamond Block", "give %player_name% diamond_block 25"),
            /*90*/Arrays.asList("&7 130k", "eco give %player_name% 130000"),
            /*91*/Arrays.asList("&7 5x Nether Star", "give %player_name% nether_star 5"),
            /*92*/Arrays.asList("&7 3x Beacon", "give %player_name% beacon 3"),
            /*93*/Arrays.asList("&7 150k", "eco give %player_name% 150000"),
            /*94*/Arrays.asList("&7 20x Notch Apple", "give %player_name% enchanted_golden_apple 20"),
            /*95*/Arrays.asList("&7 9x Wither Scheleton Head", "give %player_name% wither_skeleton_skull 9"),
            /*96*/Arrays.asList("&7 10x Netherite Block ", "give %player_name% netherite_block 10"),
            /*97*/Arrays.asList("&7 32x Notch Apple", "give %player_name% enchanted_golden_apple 32"),
            /*98*/Arrays.asList("&7 200k", "eco give %player_name% 200000"),
            /*99*/Arrays.asList("&7 96x Diamond Block", "give %player_name% diamond_block 96"),
            /*100*/Arrays.asList("&7 64x Notch Apple", "give %player_name% enchanted_golden_apple 64")
    );


    public static Gwlevels INSTANCE;
    public static final String VERSION = "1.0";


    //1 = light blue
    //2 = yellow

    public static final List<Integer> levelInv_color1 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,17,18,19,25,26,27,28,34,35);
    public static final List<Integer> levelInv_color2 = Arrays.asList(36,37,38,39,40,41,42,43,44,45,46,47,51,52,53);
    public static final List<Integer> levelInv_levelSlots = Arrays.asList(10,11,12,13,14,15,16,20,21,22,23,24,30,31,32);

    public static final List<Integer> levelTopInv_color1 = Arrays.asList(0,1,9,10,12,13,15,16,18,21,25,27,36,37,38,45,46,47,48,49,50,51,52,53);
    public static final List<Integer> levelTopInv_color2 = Arrays.asList(2,3,4,5,6,7,8,11,17,20,26,29,35,38,39,40,41,42,43,44);
    public static final List<Integer> levelTopInv_playerSlots = Arrays.asList(14,22,23,24,30,31,32,33,34,35);

    public static final List<Integer> helpInv_color1 = Arrays.asList(0,2,3,5,6,8,9,11,12,14,15,17,18,20,21,23,24,26);
    public static final List<Integer> helpInv_color2 = Arrays.asList(1,4,7,19,22,25);

    public static NamespacedKey rewardKey;
    public static NamespacedKey nextKey;
    public static NamespacedKey backKey;
    public static NamespacedKey helpKey;
    public static NamespacedKey viewTopKey;

    private static HashMap<String, Double> dataLevel = new HashMap<>();
    private static HashMap<String, String> dataClaimed = new HashMap<>();



    @Override
    public void onEnable() {
        INSTANCE = this;

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPI().register();
        } else {

            System.out.println("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            System.out.println("Could not find Vault! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);

        rewardKey = new NamespacedKey(this,"claim");
        nextKey = new NamespacedKey(this,"next");
        backKey = new NamespacedKey(this,"back");
        helpKey = new NamespacedKey(this,"help");
        viewTopKey = new NamespacedKey(this,"viewtop");

        getServer().getConsoleSender().sendMessage("\n  _____       _             __         _     ______                                           \n |_   _|     (_)           [  |       / |_  |_   _ `.                                         \n   | |       __     .--./)  | |--.   `| |-'   | | `. \\  _ .--.   .---.   ,--.    _ .--..--.   \n   | |   _  [  |   / /'`\\;  | .-. |   | |     | |  | | [ `/'`\\] / /__\\\\ `'_\\ :  [ `.-. .-. |  \n  _| |__/ |  | |   \\ \\._//  | | | |   | |,   _| |_.' /  | |     | \\__., // | |,  | | | | | |  \n |________| [___]  .',__`  [___]|__]  \\__/  |______.'  [___]     '.__.' \\'-;__/ [___||__||__] \n                  ( ( __))                                                                    ");

        //DatabaseConnector.sqlSetup();

        this.getServer().getPluginManager().registerEvents(new EntityKillEvent(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClickEvent(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);

        Objects.requireNonNull(this.getCommand("dev-main")).setExecutor(new CommandManager());
        Objects.requireNonNull(this.getCommand("gwadmin")).setExecutor(new CommandManager());
        Objects.requireNonNull(this.getCommand("gwlevel")).setExecutor(new CommandManager());
        Objects.requireNonNull(this.getCommand("gwtop")).setExecutor(new CommandManager());

        DataHolder.updateData();

        HashMap<String, String> var1 = Utils.load("level");

        for(String s : var1.keySet())
            dataLevel.put(s, Double.valueOf(var1.get(s)));

        dataClaimed = Utils.load("claimed");
    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();

        Utils.save(dataLevel, "level");
        Utils.save(dataClaimed, "claimed");
    }

    // ------------------------------ Getters ------------------------------

    /**
     * Generates and returns level inventory.
     * @param player Player Instance
     * @param page The page of the level inventory you want to get
     * @return Level Inventory
     */
    public static Inventory getLevelInventory(Player player, int page) {
        Inventory levelInv = player.getOpenInventory().getTopInventory();

        char[] data = getClaimedData(player.getName()).toCharArray();

        for(int pos : levelInv_levelSlots)
            levelInv.setItem(pos, null);

        for(int i=0;i<Math.min(levelInv_levelSlots.size(), data.length - page * 15);i++)
        {
            if(data[i + 15 * page] == '1')
                levelInv.setItem(levelInv_levelSlots.get(i), ItemsInit.getLevelRewardClaimed("&b&lLevel &e" + (i + 1 + page * 15), i + page * 15));
            else
                levelInv.setItem(levelInv_levelSlots.get(i), ItemsInit.getLevelRewardUnclaimed("&b&lLevel &e" + (i + 1 + page * 15), i + page * 15));
        }

        if(page == 0) {
            for(int i : levelInv_color1)
                levelInv.setItem(i, ItemsInit.getPaneColor1());
            for(int i : levelInv_color2)
                levelInv.setItem(i, ItemsInit.getPaneColor2());

            ItemStack next = ItemsInit.getHead("arrowRight");
            assert next != null;
            ItemMeta meta = next.getItemMeta();
            assert meta != null;
            meta.getPersistentDataContainer().set(Gwlevels.nextKey, PersistentDataType.STRING, "next");
            next.setItemMeta(meta);
            levelInv.setItem(33, next);
            levelInv.setItem(29, ItemsInit.getBarrier());
        }
        else if (page == 6) {
            ItemStack back = ItemsInit.getHead("arrowLeft");
            assert back != null;
            ItemMeta meta = back.getItemMeta();
            assert meta != null;
            meta.getPersistentDataContainer().set(Gwlevels.backKey, PersistentDataType.STRING, "back");
            back.setItemMeta(meta);
            levelInv.setItem(29, back);
            levelInv.setItem(33, ItemsInit.getBarrier());
        }
        else {
            ItemStack back = ItemsInit.getHead("arrowLeft");
            assert back != null;
            ItemMeta meta = back.getItemMeta();
            assert meta != null;
            meta.getPersistentDataContainer().set(Gwlevels.backKey, PersistentDataType.STRING, "back");
            back.setItemMeta(meta);
            levelInv.setItem(29, back);

            ItemStack next = ItemsInit.getHead("arrowRight");
            assert next != null;
            meta = next.getItemMeta();
            assert meta != null;
            meta.getPersistentDataContainer().set(Gwlevels.nextKey, PersistentDataType.STRING, "next");
            next.setItemMeta(meta);
            levelInv.setItem(33, next);
        }

        ItemStack help = ItemsInit.getHead("help");
        assert help != null;
        ItemMeta meta = help.getItemMeta();
        assert meta != null;
        meta.getPersistentDataContainer().set(Gwlevels.helpKey, PersistentDataType.STRING, "help");
        help.setItemMeta(meta);
        levelInv.setItem(48, help);

        ItemStack top = ItemsInit.getHead("top");
        assert top != null;
        meta = top.getItemMeta();
        assert meta != null;
        meta.getPersistentDataContainer().set(Gwlevels.viewTopKey, PersistentDataType.STRING, "top");
        top.setItemMeta(meta);
        levelInv.setItem(50, top);

        levelInv.setItem(49, ItemsInit.getPlayerInfoItem(player.getName()));

        return levelInv;
    }

    /**
     * Generates the top level inventory with the informations that it already have.
     * @return Top Level Inventory
     */
    public static Inventory getTopLevelInventory() {
        Inventory levelTopInv = Bukkit.createInventory(null, 54, "Level TOP");
        ArrayList<String> data = Gwlevels.getTopPlayers();


        for(int i : levelTopInv_color1)
            levelTopInv.setItem(i, ItemsInit.getPaneColor1());
        for(int i : levelTopInv_color2)
            levelTopInv.setItem(i, ItemsInit.getPaneColor2());
        for(int i=0;i<Math.min(levelTopInv_playerSlots.size(), data.size());i++)
            levelTopInv.setItem(levelTopInv_playerSlots.get(i), ItemsInit.getTopPlayerHead(data.get(i),i));

        return levelTopInv;
    }

    /**
     * Generates the help inventory
     * @param player Player Instance
     * @return Help Inventory
     */
    public static Inventory getHelpInventory(Player player) {
       Inventory helpInv = Bukkit.createInventory(null, 27, "HELP!");

       for(int i : helpInv_color1)
           helpInv.setItem(i, ItemsInit.getPaneColor1());
       for(int i : helpInv_color2)
           helpInv.setItem(i, ItemsInit.getPaneColor2());

        helpInv.setItem(10, ItemsInit.getHelp1(player));
        helpInv.setItem(13, ItemsInit.getHelp2());
        helpInv.setItem(16, ItemsInit.getHelp3());



        return helpInv;
    }

    /**
     * Gets the level of player formatted.
     * @param player Player Name
     * @return Formatted Level String
     */
    public static String getLevelFormated(String player) {
        String icon = "█";
        StringBuilder output = new StringBuilder();

        for(int i=0;i<(int)Math.floor(10 * (getXP(player) - getXP((int)Math.floor(getLevel(player)))) / (getXP(1 + (int)Math.floor(getLevel(player))) - getXP((int)Math.floor(getLevel(player)))));i++)
            output.append("&b").append(icon);
        for(int i=(int)Math.floor(10 * (getXP(player) - getXP((int)Math.floor(getLevel(player)))) / (getXP(1 + (int)Math.floor(getLevel(player))) - getXP((int)Math.floor(getLevel(player)))))+1;i<=10;i++)
            output.append("&7").append(icon);
        return output.toString();
    }

    /**
     * Gets the percent done from a level of player.
     * @param player Player Name
     * @return Level Percent String
     */
    public static String getLevelPercent(String player) {
        return (int) Math.floor(10000 * (getXP(player) - getXP((int) Math.floor(getLevel(player)))) / (getXP(1 + (int) Math.floor(getLevel(player))) - getXP((int) Math.floor(getLevel(player))))) / 100.0 + "%";
    }


    // ------------------------------ Database / Files OPS ------------------------------

    //Level

    /**
     * Sets the level of a player.
     * @param player Player Name
     * @param level Level
     * @throws NoUserFound if the user has not been found
     */
    public static void setLevel (String player, int level) throws NoUserFound {
        double XP = Math.ceil(getXP(level)) + 1;
        setXP(player, XP);
    }

    /**
     * Adds level to a player.
     * @param player Player Name
     * @param level Level
     * @throws NoUserFound if the user has not been found
     */
    public static void addLevel (String player, int level) throws NoUserFound {
        double XP = (int)Math.ceil(getXP(level)) + 1 + getXP(player);
        setXP(player, XP);
    }

    /**
     * Converts XP into Level.
     * @param xp XP
     * @return Level
     */
    public static double getLevel(double xp) {
        if(xp == 0)
            return 0;
        return log((13 * xp + 1599)/ (13000 - 1000 * Math.pow(130, 1.0/2.0)), 13.0/10.0);
    }

    /**
     * Gets the level of one player.
     * @param player Player Name
     * @return Level
     */
    public static double getLevel(String player) {
        return getLevel(getXP(player));
    }


    /**
     * Sets the XP for a player.
     * @param player Player Name
     * @param XP XP of the player
     * @throws NoUserFound if the user has not been found
     */
    public static void setXP(String player, double XP) throws NoUserFound {
        dataLevel.put(player, XP);
    }

    /**
     * Adds XP to a player.
     * @param player Player Name
     * @param XP XP of the player
     * @throws NoUserFound if the user has not been found
     */
    public static void addXP(String player, double XP) throws NoUserFound {
        setXP(player, XP + getXP(player));
    }

    /**
     * Gets the player level.
     * @param player Player Name
     * @return Player Level
     * @throws NoUserFound if the user has not been found
     */
    public static double getXP(String player) throws NoUserFound {
        return dataLevel.getOrDefault(player, 0.0);
    }

    /**
     * Transforms level into XP
     * @param level Level
     * @return XP
     */
    public static double getXP(int level) {
        if(level == 0)
            return 0;
        return 1000 * (Math.pow(1.3, level) - Math.pow(1.3, level-0.5)) - 123;

    }


    /**
     * Sets the claimed rewards
     * @param player Player Name
     * @param data String of data 1 0
     * @throws NoUserFound if the user has not been found
     */
    public static void setClaimedData(String player, String data)  throws NoUserFound {
        dataClaimed.put(player, data);
    }

    /**
     * Gets the claimed rewards
     * @param player Player Name
     * @return String of data 1 0
     * @throws NoUserFound if the user has not been found
     */
    public static String getClaimedData(String player) throws NoUserFound {
        return dataClaimed.getOrDefault(player, "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    }

    /**
     * Gets a list of Top Level Players
     * @return List of Top Level Players
     */
    public static ArrayList<String> getTopPlayers() {
        //TODO: Solve
        return new ArrayList<>();
    }

    /**
     * Gets info about a player
     * @param player Player Name
     * @return Player Info
     * @throws NoUserFound if the user has not been found
     */
    public static String getInfo (String player) throws NoUserFound {
        try {
            return "&e&l" + player + "\n\n&bXP:&f " + Math.floor(getXP(player)) + "\n&bLevel:&f " + Math.floor(getLevel(player)) + "\n&bRankup:&f " + getLevelFormated(player) + "&7(&a" + getLevelPercent(player) + "&7)";
        } catch (NoUserFound e) {
            throw new NoUserFound();
        }
    }

    /**
     * Get the rank of a player
     * @param player Player Name
     * @return Rank of Player
     * @throws NoUserFound if the user has not been found
     */
    public static int getRankLevel(String player) throws NoUserFound {
        //TODO: Solve
        return 0;
    }



    // ------------------------------ Calculus ------------------------------
    public static double log(double a, double b) {
        return Math.log(a) / Math.log(b);
    }




}
