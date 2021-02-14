package me.lightdream.gwlevels;

import me.lightdream.gwlevels.items.ItemsInit;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class DataHolder
{
    private static Inventory topLevelInventory;
    private static HashMap<String, Double> cacheXP = new HashMap<>();


    // ------------------------------ Updater ------------------------------
    public static void updateData()
    {
        Bukkit.getScheduler().runTaskTimer(Gwlevels.getPlugin(), () -> {
            topLevelInventory = Gwlevels.getTopLevelInventory();
        }, 0L, 6000L);
    }


    // ------------------------------ Getter ------------------------------
    public static Inventory getTopLevelInventory(String player){
        Inventory output = topLevelInventory;

        ItemStack playerInfo = ItemsInit.getPlayerInfoItem(player);

        topLevelInventory.setItem(19, playerInfo);
        topLevelInventory.setItem(28, playerInfo);

        return output;
    }

    public static void addXPtoCache(String player, Double xp)
    {
        if(cacheXP.containsKey(player))
            cacheXP.put(player, xp + Gwlevels.getXP(player));
        else
            cacheXP.put(player, xp + cacheXP.get(player));
    }

    public static Double getXPfromCache(String player)
    {
        if(cacheXP.containsKey(player))
            return cacheXP.get(player);
        else
        {
            Double xp = Gwlevels.getXP(player);
            cacheXP.put(player, xp);
            return xp;
        }
    }

    public static void setXPtoCache(String player, Double xp)
    {
        cacheXP.put(player, xp + cacheXP.get(player));
    }



}
