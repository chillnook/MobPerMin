package com.chill.mobmins.commands;

import com.chill.mobmins.MobMins;
import com.chill.mobmins.events.LoopEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        FileConfiguration config = MobMins.getInstance().getConfig();

        if(!(sender instanceof Player)) {

            MobMins.Print(ChatColor.YELLOW, "Try running this command again from a player.");

            return true;

        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("start")) {

            if(config.getBoolean("Start.Enabled")) {

                config.set("Start." + ".Enabled", true);
                player.sendMessage(ChatColor.RED + "[MobMins] Mob spawning enabled.");

                //Config saving
                try {
                    MobMins.getInstance().getConfig().save("plugins/MobMins/config.yml");
                } catch (IOException e) {
                    e.printStackTrace();
                    MobMins.Print(ChatColor.RED, "Could not save config! Report this to the developer.");
                }

                //Enable mob event
                for(Player p : Bukkit.getOnlinePlayers()) {



                }

            }
            else{

                config.set("Start." + ".Enabled", false);
                player.sendMessage(ChatColor.GREEN + "[MobMins] Mob spawning disabled.");

            }

        }

        return true;
    }
}
