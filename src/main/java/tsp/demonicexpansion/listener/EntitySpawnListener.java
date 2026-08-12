package tsp.demonicexpansion.listener;

import org.bukkit.World;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import tsp.demonicexpansion.implementation.entity.Entities;
import cl.jackstar.smartplugin.handler.Handler;
import cl.jackstar.smartplugin.utils.NumberUtils;

public class EntitySpawnListener extends Handler {

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if (event.getLocation().getWorld().getEnvironment() == World.Environment.NETHER) {
            if (event.getEntity() instanceof WitherSkeleton) {
                NumberUtils.chance(5, s -> {
                    event.setCancelled(true);
                    Entities.REAPER.spawn(event.getLocation());
                }, ignored -> {});
            } else if (event.getEntity() instanceof MagmaCube) {
                NumberUtils.chance(50, s -> {
                    event.setCancelled(true);
                    Entities.VULCAN.spawn(event.getLocation());
                }, ignored -> {});
            } else if (event.getEntity() instanceof PigZombie) {
                NumberUtils.chance(70, s -> {
                    event.setCancelled(true);
                    Entities.NECROMANCER.spawn(event.getLocation());
                }, ignored -> {});
            } else if (event.getEntity() instanceof Hoglin) {
                NumberUtils.chance(50, s -> {
                    event.setCancelled(true);
                    Entities.NECROMANCER.spawn(event.getLocation());
                }, ignored -> {});
            }
        }
    }

}
