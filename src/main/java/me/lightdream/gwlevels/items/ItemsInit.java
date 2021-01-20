package me.lightdream.gwlevels.items;

import me.lightdream.gwlevels.Gwlevels;
import me.lightdream.gwlevels.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class ItemsInit {

    public static ItemStack getPaneColor1()
    {
        return new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayName(" ").build();
    }

    public static ItemStack getPaneColor2()
    {
        return new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayName(" ").build();
    }

    public static ItemStack getLevelRewardUnclaimed(String name, int level)
    {
        ItemStack output = new ItemBuilder(Material.CHEST_MINECART).setDisplayName(Utils.color(name)).setLore(Utils.color(Gwlevels.rewards.get(level).get(0)).split("%newline%")).build();
        ItemMeta meta = output.getItemMeta();
        assert meta != null;
        meta.getPersistentDataContainer().set(Gwlevels.rewardKey, PersistentDataType.STRING, "claim");
        output.setItemMeta(meta);
        return output;
    }

    public static ItemStack getLevelRewardClaimed(String name, int level)
    {
        return new ItemBuilder(Material.MINECART).setDisplayName(Utils.color(name)).setLore(Utils.color(Gwlevels.rewards.get(level).get(0)).split("%newline%")).build();
    }

    public static ItemStack getHead(String name)
    {
        switch (name)
        {
            case "arrowLeft":
                return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&c&lBack")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDcyMzQwOTQyNSwKICAicHJvZmlsZUlkIiA6ICI2ZmU4OTUxZDVhY2M0NDc3OWI2ZmYxMmU3YzFlOTQ2MyIsCiAgInByb2ZpbGVOYW1lIiA6ICJlcGhlbXJhIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzY1ZWZmN2U2ZDBlNGY0ZTgzNzM4ZjJlOTBlMTRmZWVkZjZlMDUzMjY4MTdiZGQwNWNiODgxOTFiYjZjZmE4N2UiCiAgICB9CiAgfQp9", "ATojOg49/sLc3d6IQvrHN3I6jyTYACCa/EoFiXevi0UeMIjCQrwagH2ErHRVp8HzFXqeedaQu26yD8w8TwsK1oESx/G+Q/XUoR1komEdk1vReYdRdzbCEMml2V83E1MbWloAdf9qMfjUcO2+rGATwoH39wXoS55ijs/V2oDj0AhzIYV41YR19+Ug5HffZ39h/7ZC8nuBpajr8gZFMm7gyRdyEKFGNMaVALHbzhAcKEsKBbmsRm2PfGpSWm7rBmuEF9a78Q2egGcH45xyEqcCptRYLuq1PXPMjy8kDKi0ngBWPfWSIcHI9K+woLiXDdq7lNF9ALRCwtg5eFrz/KBDnVyC5f0iyIynpjM7cWv+1b+Ujhto520G77eOjpGaxwqNIQ5mdH+S01KwenYIAqo5CfFLSaHn16SkvFRj7Q6Of0djh/lr7lHPfocv8b5mbk9fe1oKJWxy2v5ccy/gDWcLtL55KInCMEbbahoOZqFYmAeOh9j2q89vbzZZSjCX3aYa3Ay5TEyzX2zs5GpgZSFU2W9efZECnfMCK+8TOjS//RfrQHwVnbOg/MOTgw3LUUb1sBLPukoSXU1eesRJpkZnODFqHBo07OREurmAxegs2IvzVn049Lo4Mp32tnzEucOlm5l429f7urIQOQYROqHSClxcBRAk9nPVbK5nrfUbQrM=" ).build();
            case "arrowRight":
                return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&c&lNext")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDcyMzk0ODIyNSwKICAicHJvZmlsZUlkIiA6ICI3MzgyZGRmYmU0ODU0NTVjODI1ZjkwMGY4OGZkMzJmOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJCdUlJZXQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFiMTdjNTcwNjFhNzA3NTQ1MWExNGIzNGQwYzI5ZTMyN2JmN2UxYjg0MmI2YThlMjI0MGQ5ZjZmZDVhMTUxMSIKICAgIH0KICB9Cn0=", "b/3RdT8YESsVKMZsXuaIJ8PEp94nMDWw3vTt8F4sdgeL00+jhxOqz0Nk1iAlgcP7QmbZnKDuvKuVEJhHL8Zxr6b86zgvQCH+Q/7/LMXHbfvXTBj6vhSW6KnaIkyWch13GEP5BXiV2VOI0BvsoA8Sjbw/MmA5z5h8kDGZizyH1G0seSpYCa+EOIfhWosUzdEtu/VxaikrIbC69kYnmG20SGAKF8EIImTXjc2OQYpypXl59KWLz/IQ+hR4nocjE3g4wV3g5eWkLdrDfi0jICRhh8/uQAVKiCkVdllIw1j4hIfwDp04IXSzETnaAsthpybZlIA4nmaPJ4YdEP7wQ78pd5h5xA0YyUSVkFdHJwspk0yiJ5xM2ztcf7gii6MsOGZAlj/ZjbazAwGk6HDPb+LkqnqFquh9EV1S4FALlqMnJbKWODduBMX/V5HisOXl7IR2VQqeDaxKn8LQyn1tAVdB/RSJ0jnmvVBYCB6U0mFtjVa+uzlf6Pyhzcx6ikUkqa+GF/a61qO5Wpgyw5JmMIl+05ddDFkKaXuu5hAmmVVNd0UVwcKjL7hiz0Zt7taKSUU67TBFgbKLJWHpkL/E6QneR8siXI0X+1koKDRWvVgssTuTpTWJLO/SzhddVMtozjQlJItM5G0e+ckUov+PQNIRvFwvzK8iwSb8GleU6KHm9ts=" ).build();
            case "top":
                return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&c&lVezi Topul")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDk2OTcyODAzNSwKICAicHJvZmlsZUlkIiA6ICIwZjczMDA3NjEyNGU0NGM3YWYxMTE1NDY5YzQ5OTY3OSIsCiAgInByb2ZpbGVOYW1lIiA6ICJPcmVfTWluZXIxMjMiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTVkZmEyODRhYTE1MzI0ZTUxNzg1NjFmODAzZjU5NzYyMjhkOTUxMTU1ODNhYjAzMTI2NmFlMjRlZTFhOTlkMSIKICAgIH0KICB9Cn0=", "d0UW+6gMIB+XQJ4Ofkjry7a5TmuUx1ZWkPPkNCctLAMC0abKRm6Che6UMmc/iwxOcqbwBXfDcPFFn9dYEC7KaQSjoKAqpPwCJbyCL0sXIVCNLvMgECnO3pb4mempP8FV2MwNPnyjYaC3c6zPXAGxyt3LyHM3BXK5KmpY3V5dl90DR9r67YBBnexVMCPHVGS65kxhUuVI8PdLiybQmUUKp5RMkVhs+4KTq1zPbOiNmQqyuxVjQ2hGcSFY00Eucbrfq1G7nflLRhkPUwRR2aumGgWglACdp5uZk7It7CS9v0ENhVN1pdZMxSBvYJC4eiG3BeE4JHV6kDfKEpHB+QBSeGEfFn5aQ7hWZ66MVP37EAkydgpeBj23/1bRZSKl4nAWAAC/KNpF6+YmmoDRTQVR5m1JPwZUAd3Q4Uc6AOtBUfoIf9Wdt8+FeQPkTIcENblbbfx8/8izTooKaeEQSm7zlaZJm7EVVtGfURbGsYSWVLsOSUH93an0NKhNnFEFva5r6C8xNwpuQo76zDQlD4LACveEoloo2X8X8rI3h/nmdcdZSZvbml6NEqUYb6+vjrXPQVISfnq4qqDd5Nq/eJshoZ8e1nJD9rD5XpgrZGYNvoaWITdLKA9+TpKF2a4mYsXczYspl6IrfiEcn1AY3t1ALaGCBdXQpURl9OTmL8T3SpA=" ).build();
            case "help":
                return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&c&lInformatii")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDk2OTkxMjg3MywKICAicHJvZmlsZUlkIiA6ICJmNThkZWJkNTlmNTA0MjIyOGY2MDIyMjExZDRjMTQwYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJ1bnZlbnRpdmV0YWxlbnQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3NjNiMTFkOTYwODU4YTgwNDNmZjFkMTQ2YTk2MGYxYTg4YWVlOGM0YmNlOGEwZDMyOWQ0YWM5NWI2ZmMxNSIKICAgIH0KICB9Cn0=", "azO1PYYfl4F9irG0Bq76Naf4atP/4fQ5iLz2W+uSz8+jsDW7Y9ZAq46VfNFn6o+tR/2YciPppAUNiA1AR37lt1fzsRzXOsOnO2IDx7iIIrUI4bN/DX1Vy7ZtHCrR2Z8hjXFQrTolo3iY3V9nWA5eUIyb2qPZ02nHYN2aOJlP7vHfO7IIBvN36P1/oqdE/u2kz5vgpubp5d5Hull/rWEmo68sDhNgQIsP++McPnn2EzdfK7x8JFNYYqejzglP0nsKfaEllPQxFkGjmQ4JQ9b8/eUqIxVgmHs2GqjtaqnoTRHPb0K/DOGOrQ1NZj7DxkIuz7w8slyo12QTV18r43E0W+lF5hvqMZGaPKBdtplZvsDH3fZ0HQKe+tDGuJzPRKW7WKEGCqdNZ84TzyvCsl/Y87hm/sVA4GiOLZEZC4IUeueUL6jQAUuRVo+l6qM75YaXFFCvGBIb98vL1zGw+zN+1++LQTq65Z+48bZ2i4MRPT0PpZzH5bKEqwMweg2H0BoXxa4Epl0ghzS66l5jMR8HQpLQS+55FkJH36u2Lfpm7cG0vv4aswU3tvZn52uVEGMVgh1rmSxgF4EUMrlXZNjuWLDx/6rF6XvgK9OtW9jf4WoxP41Hrbr7S7z5PMe7sYOikvdsWwnuOUEcoT8wxUHwzCCoM4C7w9pqbkJzXUdtFu0=" ).build();
        }
        return null;
    }

    public static ItemStack getBarrier()
    {
        ItemStack output = new ItemStack(Material.BARRIER);
        ItemMeta meta = output.getItemMeta();
        meta.setDisplayName(" ");
        meta.setLore(new ArrayList<>());
        output.setItemMeta(meta);
        return output;
    }

    public static ItemStack getPlayerInfoItem(String player)
    {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(Utils.color("&fNume&f: &b" + player));
        lore.add(Utils.color("&fRank&f: &b" + Gwlevels.getRankLevel(player)));
        lore.add("");
        lore.add(Utils.color("&fXP&f: &b" + (int)Gwlevels.getXP(player)));
        lore.add(Utils.color("&fLevel&f: &b" + (int)Math.floor(Gwlevels.getLevel(player))));
        lore.add(Utils.color("&fProgres&f: &b" + Gwlevels.getLevelFormated(player) + "&7( &a" + Gwlevels.getLevelPercent(player) + "&7)"));

        return new ItemBuilder(Material.PLAYER_HEAD).setDisplayName(Utils.color("&e&lProfilul tau")).setHead(player).setLore(lore).build();
    }

    public static ItemStack getTopPlayerHead(String player, int top)
    {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(Utils.color("&fXP&f: &b" + (int)Gwlevels.getXP(player)));
        lore.add(Utils.color("&fLevel&f: &b" + (int)Math.floor(Gwlevels.getLevel(player))));
        lore.add(Utils.color("&fProgres&f: &b" + Gwlevels.getLevelFormated(player) + "&7( &a" + Gwlevels.getLevelPercent(player) + "&7)"));

        return new ItemBuilder(Material.PLAYER_HEAD).setDisplayName(Utils.color("&b&l#" + top + " &e&l" + player)).setHead(player).setLore(lore).build();
    }

    public static ItemStack getHelp1(Player player)
    {
        double baseMob = Gwlevels.getPlugin().getConfig().getDouble("mob-kill-xp");
        double basePlayer = Gwlevels.getPlugin().getConfig().getDouble("player-kill-xp");
        double baseMultiplier = Gwlevels.getPlugin().getConfig().getDouble("muliplier");
        double rankMultiplier = 1;

        if (player.hasPermission("gw.xp.vip"))
            rankMultiplier = Gwlevels.getPlugin().getConfig().getDouble("rank-multiplier");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(Utils.color("&f1. &b" + baseMob * baseMultiplier * rankMultiplier + " &fpentru omorarea unui mob."));
        lore.add(Utils.color("&f2. &b" + basePlayer * baseMultiplier * rankMultiplier + " &fpentru omorarea unui player."));
        lore.add(Utils.color("&fMai multe modalitati vor fi adaugate in viitor"));

        return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&e&lCum fac rost de XP?")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDk5NzQ2MjIxMywKICAicHJvZmlsZUlkIiA6ICI5OTdjZjFlMmY1NGQ0YzEyOWY2ZjU5ZTVlNjU1YjZmNyIsCiAgInByb2ZpbGVOYW1lIiA6ICJpbzEyIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMyNTUzMjdkZDhlOTBhZmFkNjgxYTE5MjMxNjY1YmVhMmJkMDYwNjVhMDlkNzdhYzE0MDg4MzdmOWUwYjI0MiIKICAgIH0KICB9Cn0=", "l/29ED2td3BNajIvF48AKX2ZKCfe43lfkaGKE+vbQbFs9v2ttPFvCprrkJniBniTIndHIoD06xyVl+oV4BYqRRmgKglRMJQKEJOMYqHbbbs5u+1bZBdbKNr+hVawaaci1IjRRkShRdzjrtoEiG1lNArmibvGQWgpSp8/p/HagiHvzGkJbZ7tmb0mCLn/CFez7ueNCbyBKafRkEFSeHP7Y/qDcfBNPO40Ez0si4fZsflseFAN3jD1ctc66eoSD6RxYKqtOJudWc+Rd9KwNELxWp+Eq4sqZuNJh6D0O8/VExpto2rvdLFbr2LYJqa120JKr+S0qlv0jWtV5F8/n2KQyKiJMGWssWXhqJn9um/uf53Y3+Y2ImU3EjCRKhVFPMc7bD1vij11lxvjbkPgxIgQoon4wxMVQqaawBGxmOIJdJ1uE+nUOxgiFoD2OfMwPalm6dDm90lpx8H0lb5da7CRVkIbO2psp9Zy0mq3vvZ+Rmo4HpZ9SKmUUbqkB/ROo/yxt2rR5ScN5bDtmKLv1B08QuekMRE2/Z1i/tRCZrtinWHwZ0HP3JRlra10gzWZox90ucS5b62lFitIXzAJQPySFPbaKCHXyvo5U5TGq/bsDPTNI7HEdYGLGxVZ0fPCuGC2tJyMPMxx/iGzmyfaZjEARZr9eFnYOa/JhtdjBCK+NM8=" ).setLore(lore).build();
    }

    public static ItemStack getHelp2()
    {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(Utils.color("&fXP-ul este folosit automat pentru a primit rankup. Folosing comanda /level"));
        lore.add(Utils.color("&fputeti vedea rewardurile disponoibile precum si progresul facut"));

        return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&e&lCum folosesc XP-ul?")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDk5Nzk1OTQyOCwKICAicHJvZmlsZUlkIiA6ICI1NjY3NWIyMjMyZjA0ZWUwODkxNzllOWM5MjA2Y2ZlOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVJbmRyYSIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9mZWUxNDM5MWIxNTgwZTBkY2VhZmYzMzc0ZThjNzg4MTIxYjFhNjE4YjgyZjI0YzU5MDgwMmY2NGI4MzllNDczIgogICAgfQogIH0KfQ==", "cmRfNEDktmQM+n0+DdX200Q51taDHSgQqz67idNAAhU1Gj+OKedZJ2y+TDVp00xWRj5Hjv94JZbMQ8BbgRwRE/Igy+ljqjfjWLDZP/81orn0G2QY94bXihkNnmh8O+kzbKTvXMumGrg4nb61IaAYXsLInBffs2aR3wuabniG5zzcbtiey9ZN8ZchQCj3QmHerBuqtzLXUPQb92ZFD6u27O3/QyORHWX2Nw2LW/rJLaGlB9AqMEV/FlnSfIPVsTM7kpPOuBSdT5RgYjwsaSCqR9NdrvLvkN6hfV3jRiiA7QZsejRcOw9hN1lYhO5GMzv33sZSrlaWXPhVjAYbCZz2L9HoQxJoIST4h2ZwaYL3H900/MZlPkhN0EkKiU0IjXJl7x81R8oLm8HONI+vPoQBhC5WPej6Fxpwnl89oStuZt0l6BBgTJQ7FBTRMab/QOFt+15P88e6fywMT4jxKNxio4rkSs1PhdVb9nxE12Qyf4/q1e7F8WBsG4nBHagPD9kY2zBbJ7f/J7cnuktpNmqZOAykWQ3UhyaitBBiNsZ3dq4BLqpiAP3rKykzpz1ETOrTwIOH6mS6u4+R0t/mgFVSAiMFG2ds6XMosrxOCDX1m3S7XpWyirHDvAW8eftidpKkoiV6KuUkZE44UQEKfpnW4xFkXW3kyfg6JCLqXO4NCqg=" ).setLore(lore).build();
    }

    public static ItemStack getHelp3()
    {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(Utils.color("&cIN CURAND"));

        return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&e&lConcursuri")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "eyJ0aW1lc3RhbXAiOjE1NjQ5MzQ3OTY5MjgsInByb2ZpbGVJZCI6IjkwMmY3YzRhYmM3YTQwODk4OWFhMzgyYzNiYTIxZjcyIiwicHJvZmlsZU5hbWUiOiJLVFhmb3JnZW9tYW0iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc3YzJiMGUzZjNmN2VhNWRlYzgzZTQ0NTEyYjRlNDUyYWY0NmNlNGQ5YmZiMzk1ODRiOTMzNWZmM2QzY2QzNWIifX19", "n7XqOSSVoSIfIiieddwPpx3Tx7vHvwPhOzGmSKEHXzj9LJlXxFGN3Vjohgx0FVYWol6T+AattHpIA+riivigLDqePU0pFVlX7azoMuvmTbic013iXidcjCb6Wx5/tevcrOva80gSP2LzzA2lSh6EHOxmnfdsIZrVy5LQrDZ/H3YsTlmCZ7mCa8n+TwTJ0CyR0hIpYY9xXwhbpQKRV1GLFYw78aOVIWIS3IfIWmYb4gXPc+Y8I4tfV7l0qTEvo8+q8LEFiEGiuEI4Et/YOKNV1rA8cKBcJQkQRf2uVyoKeIZLBSNfCfPmxhgubiq6TAXtKrklxf5DR9bhnPkxOOtE6Dq+P6E6O+gE81qB5yNup4UwAfbWWXj+XPJxQUEh8qZ92ZE1yU1rHZ0YDREDHl6dNnHUUf9DNBiEvn52dParq01v2U4nlE1KNDs6Yo6seyyWIW2bS9mTvckzqBcyNfjzdCQ6e+GL9B0HHDICxuzpI7B2OsI0zSZS/L+APii0AAr+INTDuSez4V+fLcZwIRN/nt+2KPCaYxAT5IBeyTetFU78aP7YmQz30AIH+es6V52IQF+2rAETMQghb8xEIp7TUiqU04FhYvlSZZWjueuELjX2KkKL6wv9VC95x6o8ABCUWEECOtyHhbAYqLY5GpTMeGR/vEvPl5mksisGeVPHyCs=" ).setLore(lore).build();
    }

    public static ItemStack getBedWarsTag(String player)
    {
        ArrayList<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(Utils.color("&fRank: " + Gwlevels.getRankBedWars(player)));

        return new ItemBuilder(Material.NAME_TAG).setDisplayName(Utils.color("&b&lBedWars &e&lTAG")).setLore(lore).build();
    }

    public static ItemStack getParkourTag(String player)
    {
        ArrayList<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(Utils.color("&fRank: " + Gwlevels.getRankParkour(player)));

        return new ItemBuilder(Material.NAME_TAG).setDisplayName(Utils.color("&b&lParkour &e&lTAG")).setLore(lore).build();
    }

    public static ItemStack getLevelTag(String player)
    {
        ArrayList<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(Utils.color("&fRank: " + Gwlevels.getRankLevel(player)));

        return new ItemBuilder(Material.NAME_TAG).setDisplayName(Utils.color("&b&lLevel &e&lTAG")).setLore(lore).build();
    }

}
