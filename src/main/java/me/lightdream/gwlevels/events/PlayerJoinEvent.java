package me.lightdream.gwlevels.events;

import me.lightdream.gwlevels.Gwlevels;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    private void onPlayerJoin (org.bukkit.event.player.PlayerJoinEvent event)
    {
        Gwlevels.addXP(event.getPlayer().getName(), 0);
    }


}
