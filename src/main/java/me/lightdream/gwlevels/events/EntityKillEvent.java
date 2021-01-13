package me.lightdream.gwlevels.events;


import me.lightdream.gwlevels.Gwlevels;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityKillEvent implements Listener {

    @EventHandler
    public void onEntityKill(EntityDeathEvent event)
    {
        if(event.getEntity().getKiller() != null && event.getEntity().getKiller().getPlayer() != null) {

            if(event.getEntity() instanceof Mob ) {

                Player killer = event.getEntity().getKiller().getPlayer();

                double base = Gwlevels.getPlugin().getConfig().getDouble("mob-kill-xp");
                double baseMultiplier = Gwlevels.getPlugin().getConfig().getDouble("muliplier");
                double rankMultiplier = 1;

                if (killer.hasPermission("gw.xp.vip"))
                    rankMultiplier = Gwlevels.getPlugin().getConfig().getDouble("rank-multiplier");

                Gwlevels.addPoints(event.getEntity().getKiller().getPlayer().getName(), base * baseMultiplier * rankMultiplier);
                System.out.println("Mob Kill " + base * baseMultiplier * rankMultiplier);
            }

            else if (event.getEntity() instanceof Player)
            {
                Player killer = event.getEntity().getKiller().getPlayer();

                double base = Gwlevels.getPlugin().getConfig().getDouble("player-kill-xp");
                double baseMultiplier = Gwlevels.getPlugin().getConfig().getDouble("muliplier");
                double rankMultiplier = 1;

                if (killer.hasPermission("gw.xp.vip"))
                    rankMultiplier = Gwlevels.getPlugin().getConfig().getDouble("rank-multiplier");

                Gwlevels.addPoints(event.getEntity().getKiller().getPlayer().getName(), base * baseMultiplier * rankMultiplier);
                System.out.println("Player Kill " + base * baseMultiplier * rankMultiplier);
            }
        }

    }
}
