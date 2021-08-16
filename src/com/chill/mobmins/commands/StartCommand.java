package com.chill.mobmins.commands;

import com.chill.mobmins.MobMins;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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

            if(config.getBoolean("Start.Enabled") == false) {

                config.set("Start." + ".Enabled", true);

                EntityType[] mobs = Arrays.stream(EntityType.values())
                        .filter(type -> type.getEntityClass() != null && Mob.class.isAssignableFrom(type.getEntityClass()))
                        .toArray(EntityType[]::new);
                EntityType randomMob = mobs[ThreadLocalRandom.current().nextInt(mobs.length)];

                player.getWorld().spawnEntity(player.getLocation(), randomMob);

                player.sendMessage(ChatColor.GREEN + "[MobMins] Mob spawning enabled.");

                try {
                    MobMins.getInstance().getConfig().save("plugins/MobMins/config.yml");
                } catch (IOException e) {
                    e.printStackTrace();
                    MobMins.Print(ChatColor.RED, "Could not save config! Report this to the developer.");
                }

            }
            else{

                config.set("Start." + ".Enabled", false);
                player.sendMessage(ChatColor.GREEN + "[MobMins] Mob spawning disabled.");

                try {
                    MobMins.getInstance().getConfig().save("plugins/MobMins/config.yml");
                } catch (IOException e) {
                    e.printStackTrace();
                    MobMins.Print(ChatColor.RED, "Could not save config! Report this to the developer.");
                }

                return true;

            }

        }

        return true;
    }

}
