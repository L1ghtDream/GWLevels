package me.lightdream.gwlevels.items;

import me.lightdream.gwlevels.Gwlevels;
import me.lightdream.gwlevels.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ItemsInit {


    
    public static ItemStack getLightBluePane()
    {
        ItemStack output = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta meta = output.getItemMeta();
        meta.setDisplayName(" ");
        meta.setLore(new ArrayList<>());
        output.setItemMeta(meta);
        return output;
    }

    public static ItemStack getYellowPane()
    {
        ItemStack output = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta meta = output.getItemMeta();
        meta.setDisplayName(" ");
        meta.setLore(new ArrayList<>());
        output.setItemMeta(meta);
        return output;
    }

    public static ItemStack getLevelRewardUnclaimed(String name, int level)
    {
        ItemStack output = new ItemStack(Material.CHEST_MINECART);
        ItemMeta meta = output.getItemMeta();
        meta.setDisplayName(Utils.color(name));
        if(Gwlevels.rewards.size() > level)
        {
            List<String> list = new ArrayList<>();
            if(Gwlevels.rewards.get(level).get(0).contains("%newline%"))
                for(String s : Gwlevels.rewards.get(level).get(0).split("%newline%"))
                    list.add(Utils.color(s));
            else
                list.add(Utils.color(Gwlevels.rewards.get(level).get(0)));
            meta.setLore(list);
        }
        else
            meta.setLore(new ArrayList<>());

        meta.getPersistentDataContainer().set(Gwlevels.rewardKey, PersistentDataType.STRING, "claim");
        output.setItemMeta(meta);
        return output;
    }

    public static ItemStack getLevelRewardClaimed(String name, int level)
    {
        ItemStack output = new ItemStack(Material.MINECART);
        ItemMeta meta = output.getItemMeta();
        meta.setDisplayName(Utils.color(name));
        if(Gwlevels.rewards.size() > level)
        {
            List<String> list = new ArrayList<>();
            if(Gwlevels.rewards.get(level).get(0).contains("%newline%"))
                for(String s : Gwlevels.rewards.get(level).get(0).split("%newline%"))
                    list.add(Utils.color(s));
            else
                list.add(Utils.color(Gwlevels.rewards.get(level).get(0)));
            meta.setLore(list);
        }
        else
            meta.setLore(new ArrayList<>());
        //meta.getPersistentDataContainer().set();



        output.setItemMeta(meta);
        return output;
    }

    public static ItemStack getHead(String name)
    {
        switch (name)
        {
            case "arrowLeft":
                return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&c&lBack")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDcyMzQwOTQyNSwKICAicHJvZmlsZUlkIiA6ICI2ZmU4OTUxZDVhY2M0NDc3OWI2ZmYxMmU3YzFlOTQ2MyIsCiAgInByb2ZpbGVOYW1lIiA6ICJlcGhlbXJhIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzY1ZWZmN2U2ZDBlNGY0ZTgzNzM4ZjJlOTBlMTRmZWVkZjZlMDUzMjY4MTdiZGQwNWNiODgxOTFiYjZjZmE4N2UiCiAgICB9CiAgfQp9", "ATojOg49/sLc3d6IQvrHN3I6jyTYACCa/EoFiXevi0UeMIjCQrwagH2ErHRVp8HzFXqeedaQu26yD8w8TwsK1oESx/G+Q/XUoR1komEdk1vReYdRdzbCEMml2V83E1MbWloAdf9qMfjUcO2+rGATwoH39wXoS55ijs/V2oDj0AhzIYV41YR19+Ug5HffZ39h/7ZC8nuBpajr8gZFMm7gyRdyEKFGNMaVALHbzhAcKEsKBbmsRm2PfGpSWm7rBmuEF9a78Q2egGcH45xyEqcCptRYLuq1PXPMjy8kDKi0ngBWPfWSIcHI9K+woLiXDdq7lNF9ALRCwtg5eFrz/KBDnVyC5f0iyIynpjM7cWv+1b+Ujhto520G77eOjpGaxwqNIQ5mdH+S01KwenYIAqo5CfFLSaHn16SkvFRj7Q6Of0djh/lr7lHPfocv8b5mbk9fe1oKJWxy2v5ccy/gDWcLtL55KInCMEbbahoOZqFYmAeOh9j2q89vbzZZSjCX3aYa3Ay5TEyzX2zs5GpgZSFU2W9efZECnfMCK+8TOjS//RfrQHwVnbOg/MOTgw3LUUb1sBLPukoSXU1eesRJpkZnODFqHBo07OREurmAxegs2IvzVn049Lo4Mp32tnzEucOlm5l429f7urIQOQYROqHSClxcBRAk9nPVbK5nrfUbQrM=" ).build();
            case "arrowRight":
                return new ItemBuilder( Material.PLAYER_HEAD ).setDisplayName(Utils.color("&c&lNext")).setProfileHeader( "2d8a0728-9257-4072-bd83-6b60837d77af", "ewogICJ0aW1lc3RhbXAiIDogMTYxMDcyMzk0ODIyNSwKICAicHJvZmlsZUlkIiA6ICI3MzgyZGRmYmU0ODU0NTVjODI1ZjkwMGY4OGZkMzJmOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJCdUlJZXQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFiMTdjNTcwNjFhNzA3NTQ1MWExNGIzNGQwYzI5ZTMyN2JmN2UxYjg0MmI2YThlMjI0MGQ5ZjZmZDVhMTUxMSIKICAgIH0KICB9Cn0=", "b/3RdT8YESsVKMZsXuaIJ8PEp94nMDWw3vTt8F4sdgeL00+jhxOqz0Nk1iAlgcP7QmbZnKDuvKuVEJhHL8Zxr6b86zgvQCH+Q/7/LMXHbfvXTBj6vhSW6KnaIkyWch13GEP5BXiV2VOI0BvsoA8Sjbw/MmA5z5h8kDGZizyH1G0seSpYCa+EOIfhWosUzdEtu/VxaikrIbC69kYnmG20SGAKF8EIImTXjc2OQYpypXl59KWLz/IQ+hR4nocjE3g4wV3g5eWkLdrDfi0jICRhh8/uQAVKiCkVdllIw1j4hIfwDp04IXSzETnaAsthpybZlIA4nmaPJ4YdEP7wQ78pd5h5xA0YyUSVkFdHJwspk0yiJ5xM2ztcf7gii6MsOGZAlj/ZjbazAwGk6HDPb+LkqnqFquh9EV1S4FALlqMnJbKWODduBMX/V5HisOXl7IR2VQqeDaxKn8LQyn1tAVdB/RSJ0jnmvVBYCB6U0mFtjVa+uzlf6Pyhzcx6ikUkqa+GF/a61qO5Wpgyw5JmMIl+05ddDFkKaXuu5hAmmVVNd0UVwcKjL7hiz0Zt7taKSUU67TBFgbKLJWHpkL/E6QneR8siXI0X+1koKDRWvVgssTuTpTWJLO/SzhddVMtozjQlJItM5G0e+ckUov+PQNIRvFwvzK8iwSb8GleU6KHm9ts=" ).build();
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
}
