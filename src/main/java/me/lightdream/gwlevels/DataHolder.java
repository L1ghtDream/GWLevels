package me.lightdream.gwlevels;

import me.lightdream.gwlevels.items.ItemsInit;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class DataHolder
{
    private static Inventory topLevelInventory;


    // ------------------------------ Updater ------------------------------
    public static void updateData()
    {
        Bukkit.getScheduler().runTaskTimer(Gwlevels.getPlugin(), () -> {
            topLevelInventory = Gwlevels.getTopLevelInventory();
            //Update tags for online players
        }, 0L, 1000L);
    }


    // ------------------------------ Getter ------------------------------
    public static Inventory getTopLevelInventory(String player){
        Inventory output = topLevelInventory;

        topLevelInventory.setItem(19, ItemsInit.getPlayerInfoItem(player));
        topLevelInventory.setItem(28, ItemsInit.getPlayerInfoItem(player));

        return output;
    }


}
