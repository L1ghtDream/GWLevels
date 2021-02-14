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

    /**
     * Converts to minecraft color coding
     * @param str String you want to encode
     * @return Encoded String
     */
    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * Saves the data into a file located at a location given
     * @param data Data you want to save
     * @param location Location you want to save into
     */
    public static void save(HashMap<String, ?> data, String location){

        Object[] keys = data.keySet().toArray();
        ArrayList<String> setData = new ArrayList<>();
        for(Object key : keys)
            setData.add(key.toString() + " " + data.get(key).toString());

        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("Gwlevels").getDataFolder(),  location + ".yml");
        FileConfiguration minecraft = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var8) {
                var8.printStackTrace();
            }
        }

        minecraft.set("data", setData);
        System.out.println("Data has beed saved");

        try {
            minecraft.save(file);
        } catch (IOException var7) {
            var7.printStackTrace();
        }
    }

    /**
     * Saves the data into a file located at a location given
     * @param location
     * @return
     */
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
