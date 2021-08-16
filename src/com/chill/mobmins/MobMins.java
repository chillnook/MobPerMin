package com.chill.mobmins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MobMins extends JavaPlugin {
    FileConfiguration config = getConfig();

    private static MobMins instance;

    @Override
    public void onEnable() {

        config.addDefault("Enabled.", false);
        config.options().copyDefaults(true);

        saveConfig();

        Print(ChatColor.GREEN, "[MobMins] MobMins successfully enabled.");

        instance = this;

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
