package me.lightdream.gwlevels.events;

import me.lightdream.gwlevels.Gwlevels;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    private void onPlayerJoin (org.bukkit.event.player.PlayerJoinEvent event)
    {
        new BukkitRunnable() {
            @Override public void run() {
                Gwlevels.addXP(event.getPlayer().getName(), 0);
            }
        }.runTaskAsynchronously(Gwlevels.getPlugin());


    }


}
