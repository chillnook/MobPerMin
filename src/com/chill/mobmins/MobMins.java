package com.chill.mobmins;

import com.chill.mobmins.commands.StartCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MobMins extends JavaPlugin {
    FileConfiguration config = this.getConfig();

    private static MobMins instance;

    @Override
    public void onEnable() {

        getCommand("start").setExecutor(new StartCommand());

        config.addDefault("Start." + ".Enabled", false);
        config.options().copyDefaults(true);

        saveConfig();

        Print(ChatColor.GREEN, "[MobMins] MobMins successfully enabled.");

        instance = this;

        if(config.getBoolean("Start.Enabled")) {



        }else{

            Print(ChatColor.GREEN, "[MobMins] Mob Spawning was left enabled. Disabling.");
            config.set("Start." + ".Enabled", false);
            saveConfig();

        }

    }

    @Override
    public void onDisable() {

        Print(ChatColor.RED, "[MobMins] MobMins disabled.");

    }

    public static MobMins getInstance() {
        return instance;
    }

    public static String Print(ChatColor color, String message) {

        Bukkit.getServer().getConsoleSender().sendMessage(color + message);
        return message;

    }

}
