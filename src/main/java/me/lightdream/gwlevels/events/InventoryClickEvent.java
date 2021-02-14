package me.lightdream.gwlevels.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.lightdream.gwlevels.DataHolder;
import me.lightdream.gwlevels.Gwlevels;
import me.lightdream.gwlevels.Utils;
import me.lightdream.gwlevels.items.ItemsInit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InventoryClickEvent  implements Listener {

    List<String> denyedInv = Arrays.asList("Level", "HELP!", "Level TOP");

    @EventHandler
    private void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        if (denyedInv.contains(event.getView().getTitle())) {
            int page = 0;
            if(event.getView().getTitle().equals("Level"))
                page = (Integer.parseInt(Objects.requireNonNull(Objects.requireNonNull(event.getInventory().getItem(10)).getItemMeta()).getDisplayName().replace("§b§lLevel §e", "")) + 14) / 15 - 1;
            PersistentDataContainer dataContainer = Objects.requireNonNull(Objects.requireNonNull(event.getCurrentItem()).getItemMeta()).getPersistentDataContainer();
            if (dataContainer.has(Gwlevels.rewardKey, PersistentDataType.STRING))
            {
                Player player = (Player) event.getWhoClicked();

                int level = Integer.parseInt(Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().replace("§b§lLevel §e", ""));
                if (Gwlevels.getLevel(event.getWhoClicked().getName()) >= level) {
                    for (String command : Gwlevels.rewards.get(level - 1).get(1).split("\\|")) {
                        System.out.println(command);
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), PlaceholderAPI.setPlaceholders(player, command));
                    }

                    char[] data = Gwlevels.getClaimedData(event.getWhoClicked().getName()).toCharArray();
                    data[level - 1] = '1';
                    Gwlevels.setClaimedData(event.getWhoClicked().getName(), String.valueOf(data));
                    event.getInventory().setItem(Gwlevels.levelInv_levelSlots.get(level - 1 - page * 15), ItemsInit.getLevelRewardClaimed(Utils.color("&b&lLevel &e" + level), level - 1));
                } else {
                    event.getWhoClicked().sendMessage("Nu ai nivelul necesar pentru a lua aceasta recompensa");
                }
            }
            else if
            (dataContainer.has(Gwlevels.backKey, PersistentDataType.STRING))
            {
                Inventory inv = Gwlevels.getLevelInventory((Player) event.getWhoClicked(), (page - 1));
                if (inv != null)
                    event.getWhoClicked().openInventory(inv);
            }
            else if (dataContainer.has(Gwlevels.nextKey, PersistentDataType.STRING))
            {
                Inventory inv = Gwlevels.getLevelInventory((Player) event.getWhoClicked(), (page + 1));
                if (inv != null)
                    event.getWhoClicked().openInventory(inv);
            }
            else if (dataContainer.has(Gwlevels.helpKey, PersistentDataType.STRING))
            {
                event.getWhoClicked().openInventory(Gwlevels.getHelpInventory((Player) event.getWhoClicked()));
            }
            else if (dataContainer.has(Gwlevels.viewTopKey, PersistentDataType.STRING))
            {
                event.getWhoClicked().openInventory(DataHolder.getTopLevelInventory(event.getWhoClicked().getName()));
            }


            event.setCancelled(true);
        }
    }
}
