package me.lightdream.gwlevels;

import me.lightdream.gwlevels.items.ItemsInit;
import me.lightdream.gwlevels.managers.TagManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DataHolder
{
    private static Inventory topLevelInventory;


    // ------------------------------ Updater ------------------------------
    public static void updateData()
    {
        Bukkit.getScheduler().runTaskTimer(Gwlevels.getPlugin(), () -> {
            topLevelInventory = Gwlevels.getTopLevelInventory();
            for(Player player : Bukkit.getServer().getOnlinePlayers())
                Gwlevels.getChat().setPlayerSuffix(player, Utils.color(TagManager.getRank(Gwlevels.getTagGlobally(player.getName()), player.getName())));
        }, 0L, 2000L);
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
