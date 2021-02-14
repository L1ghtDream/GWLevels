package me.lightdream.gwlevels.events;


import me.lightdream.gwlevels.Gwlevels;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityKillEvent implements Listener {

    @EventHandler
    private void onEntityKill(EntityDeathEvent event)
    {
        if(event.getEntity().getKiller() != null && event.getEntity().getKiller().getPlayer() != null) {

            if(event.getEntity() instanceof Mob ) {

                Player killer = event.getEntity().getKiller().getPlayer();

                double base = Gwlevels.getPlugin().getConfig().getDouble("mob-kill-xp");
                double baseMultiplier = Gwlevels.getPlugin().getConfig().getDouble("muliplier");
                double rankMultiplier = 1;

                if (killer.hasPermission("gw.xp.vip"))
                    rankMultiplier = Gwlevels.getPlugin().getConfig().getDouble("rank-multiplier");

                double finalRankMultiplier = rankMultiplier;
                new BukkitRunnable() {
                    @Override public void run() {
                        Gwlevels.addXP(event.getEntity().getKiller().getPlayer().getName(), base * baseMultiplier * finalRankMultiplier);
                    }
                }.runTaskAsynchronously(Gwlevels.getPlugin());


            }

            else if (event.getEntity() instanceof Player)
            {
                Player killer = event.getEntity().getKiller().getPlayer();

                double base = Gwlevels.getPlugin().getConfig().getDouble("player-kill-xp");
                double baseMultiplier = Gwlevels.getPlugin().getConfig().getDouble("muliplier");
                double rankMultiplier = 1;

                if (killer.hasPermission("gw.xp.vip"))
                    rankMultiplier = Gwlevels.getPlugin().getConfig().getDouble("rank-multiplier");

                double finalRankMultiplier = rankMultiplier;
                new BukkitRunnable() {
                    @Override public void run() {
                        Gwlevels.addXP(event.getEntity().getKiller().getPlayer().getName(), base * baseMultiplier * finalRankMultiplier);
                    }
                }.runTaskAsynchronously(Gwlevels.getPlugin());



            }
        }

    }
}
