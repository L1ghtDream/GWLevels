package me.lightdream.gwlevels;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static String color(String str)
    {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void save(HashMap<String, ?> cache, String location){

        Object[] keys = cache.keySet().toArray();
        ArrayList<String> data = new ArrayList<>();
        for(Object key : keys)
            data.add(key.toString() + " " + cache.get(key).toString());

        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("Gwlevels").getDataFolder(),  location + ".yml");
        FileConfiguration minecraft = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var8) {
                var8.printStackTrace();
            }
        }

        minecraft.set("data", data);
        System.out.println("Data has beed saved");

        try {
            minecraft.save(file);
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    public static HashMap<String, String> load(String location){
        List<String> output = new ArrayList<>();
        HashMap<String, String> data = new HashMap<>();

        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("Gwlevels").getDataFolder(), location + ".yml");
        FileConfiguration minecraft = YamlConfiguration.loadConfiguration(file);
        if (file.exists()) {
            output = minecraft.getStringList("data");
            System.out.println("Data has beed loaded");
        }
        
        for(String s : output)
            data.put(s.split(" ")[0], s.split(" ")[1]);

        return data;
    }



}
