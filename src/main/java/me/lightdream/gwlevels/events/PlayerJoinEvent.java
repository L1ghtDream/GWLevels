package me.lightdream.gwlevels.events;

import me.lightdream.gwlevels.Gwlevels;
import me.lightdream.gwlevels.Utils;
import me.lightdream.gwlevels.managers.TagManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    private void onPlayerJoin (org.bukkit.event.player.PlayerJoinEvent event)
    {
        Gwlevels.addXP(event.getPlayer().getName(), 0);
        Gwlevels.getChat().setPlayerSuffix(event.getPlayer(), Utils.color(TagManager.getRank(Gwlevels.getTagGlobally(event.getPlayer().getName()), event.getPlayer().getName())));
    }


}
