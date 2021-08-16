package com.chill.mobmins.commands;

import com.chill.mobmins.MobMins;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class StartCommand implements CommandExecutor {
    FileConfiguration config = MobMins.getInstance().getConfig();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {

            MobMins.Print(ChatColor.YELLOW, "Try running this command again from a player.");

        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("start")) {

            if(config.getBoolean("Enabled")) {

                config.set("Enabled", true);

                //Config saving
                try {
                    MobMins.getInstance().getConfig().save("plugins/MobMins/config.yml");
                } catch (IOException e) {
                    e.printStackTrace();
                    MobMins.Print(ChatColor.RED, "Could not save config! Report this to the developer.");
                }

                //Enable mob event

            }

        }

        return true;
    }
}
