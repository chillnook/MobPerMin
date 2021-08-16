package com.chill.mobmins.events;

import com.chill.mobmins.MobMins;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LoopEvent implements Listener {

    private static Player player;

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {

        player = e.getPlayer();

    }

    @EventHandler
    public static void onMobSpawn(EntitySpawnEvent e) {

        try {
            while(true) {

                System.out.println(new Date());
                Thread.sleep(5 * 1000);

            }
        } catch (InterruptedException event) {

            event.printStackTrace();

        }

        FileConfiguration config = MobMins.getInstance().getConfig();

        if(config.getBoolean("Enabled") == false) {

            return;

        }
        else{

            EntityType[] mobs = Arrays.stream(EntityType.values())
                    .filter(type -> type.getEntityClass() != null && Mob.class.isAssignableFrom(type.getClass()))
                    .toArray(EntityType[]::new);

            EntityType randomMob = mobs[ThreadLocalRandom.current().nextInt(mobs.length)];

            player.getWorld().spawnEntity(player.getLocation(), randomMob);

        }

    }

}
