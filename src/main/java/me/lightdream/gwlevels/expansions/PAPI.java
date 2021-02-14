package me.lightdream.gwlevels.expansions;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.lightdream.gwlevels.Gwlevels;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PAPI extends PlaceholderExpansion {
    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    @NotNull
    public String getAuthor(){
        return "_LightDream";
    }

    @Override
    @NotNull
    public String getIdentifier(){
        return "gwlevels";
    }

    @Override
    @NotNull
    public String getVersion(){
        return "Beta 0.2";
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier){

        if(identifier.equals("xp")){
            return String.valueOf(Gwlevels.getXP(player.getName()));
        }

        if(identifier.equals("level")) {
            String s = String.valueOf(Gwlevels.getLevel(player.getName()));
            return s.split("\\.")[0];
        }
        if(identifier.equals("level_formated")){
            return Gwlevels.getLevelFormated(player.getName());
        }
        if(identifier.equals("level_percent")){
            return Gwlevels.getLevelPercent(player.getName());
        }
        if(identifier.equals("gw_rank_level")){
            return Gwlevels.getLevelPercent(player.getName());
        }
        return null;
    }
}
