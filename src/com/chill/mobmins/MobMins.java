package com.chill.mobmins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MobMins extends JavaPlugin {

    private static MobMins instance;

    @Override
    public void onEnable() {

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
