package me.lightdream.gwlevels;

import me.lightdream.gwlevels.items.ItemsInit;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DataHolder
{
    private static Inventory topLevelInventory;

    // ------------------------------ Updater ------------------------------
    public static void updateData()
    {
        Bukkit.getScheduler().runTaskTimer(Gwlevels.INSTANCE, () -> topLevelInventory = Gwlevels.getTopLevelInventory(), 0L, 6000L);
    }


    // ------------------------------ Getter ------------------------------
    public static Inventory getTopLevelInventory(String player){
        Inventory output = topLevelInventory;

        ItemStack playerInfo = ItemsInit.getPlayerInfoItem(player);

        topLevelInventory.setItem(19, playerInfo);
        topLevelInventory.setItem(28, playerInfo);

        return output;
    }
}
