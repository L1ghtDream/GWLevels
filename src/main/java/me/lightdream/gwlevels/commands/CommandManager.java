package me.lightdream.gwlevels.commands;

import me.lightdream.gwlevels.Gwlevels;
import me.lightdream.gwlevels.exceptions.NoUserFound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {



    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("dev"))
        {
            System.out.println(Gwlevels.getXP(0));
            System.out.println(Gwlevels.getLevel(25));
        }

        if(label.equalsIgnoreCase("admin"))
        {
            if(sender.hasPermission("gw.admin"))
            {
                if(args.length == 0)
                {
                    sender.sendMessage("/admin addLevel [nume] [nivel]\n/admin setLevel [nume] [nivel]\n/admin addXP [nume] [xp]\n/admin setXP [nume] [xp]");
                }
                else {
                    if(args[0].equalsIgnoreCase("setLevel"))
                    {
                        if(args.length==3)
                        {
                            try {
                                Gwlevels.setLevel(args[1], Integer.parseInt(args[2]));
                            }
                            catch (NoUserFound e) {
                                sender.sendMessage(e.getMessage());
                            } catch ( NumberFormatException e) {
                                sender.sendMessage("The entered number is invalid");
                            }
                        }
                        else
                            sender.sendMessage("/admin setLevel [nume] [nivel]");

                    }
                    else if(args[0].equalsIgnoreCase("addLevel"))
                    {
                        if(args.length==3)
                        {
                            try {
                                Gwlevels.setLevel(args[1], Integer.parseInt(args[2]));
                            }
                            catch (NoUserFound e) {
                                sender.sendMessage(e.getMessage());
                            } catch ( NumberFormatException e) {
                                sender.sendMessage("The entered number is invalid");
                            }
                        }
                        else
                            sender.sendMessage("/admin addLevel [nume] [nivel]");
                    }
                    else if(args[0].equalsIgnoreCase("setXP"))
                    {
                        //set xp
                    }
                    else if(args[0].equalsIgnoreCase("addXP"))
                    {
                        //add xp
                    }
                }
            }
        }

        if(label.equalsIgnoreCase("calculate")) {
            if(args[0].equalsIgnoreCase("level"))
            {
                sender.sendMessage(String.valueOf(Gwlevels.getLevel(Double.parseDouble(args[1]))));
            }
            else if(args[0].equalsIgnoreCase("log"))
            {
                sender.sendMessage(String.valueOf(Gwlevels.log(Double.parseDouble(args[1]), Double.parseDouble(args[2]))));
            }
            else if(args[0].equalsIgnoreCase("xp"))
            {
                sender.sendMessage(String.valueOf(Gwlevels.getXP(Integer.parseInt(args[1]))));
            }
        }

        if(label.equalsIgnoreCase("level"))
        {

            if(sender instanceof Player)
            {
                ((Player) sender).openInventory(Gwlevels.getLevelInventory((Player) sender,0));
            }
            else
                sender.sendMessage("Only players can use this command");
        }
        return true;
    }

}
