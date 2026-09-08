package tsp.demonicexpansion.listener;

import org.bukkit.World;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import tsp.demonicexpansion.implementation.entity.Entities;
import tsp.demonicexpansion.implementation.entity.DemonicEntity;
import cl.jackstar.smartplugin.handler.Handler;
import cl.jackstar.smartplugin.utils.NumberUtils;
import com.github.drakescraft_labs.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;

public class EntitySpawnListener extends Handler {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (event.getLocation().getWorld().getEnvironment() == World.Environment.NETHER
            && isEligibleReplacementSpawn(event.getSpawnReason())) {
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

    @EventHandler(ignoreCancelled = true)
    public void onVulcanSplit(SlimeSplitEvent event) {
        if (event.getEntity() instanceof MagmaCube magmaCube && isVulcan(magmaCube)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        markLoadedVulcansNonCollidable(event.getChunk());
    }

    static boolean isEligibleReplacementSpawn(CreatureSpawnEvent.SpawnReason reason) {
        return reason == CreatureSpawnEvent.SpawnReason.NATURAL;
    }

    static boolean isLegacyVulcanName(String customName, boolean customNameVisible) {
        return customNameVisible
            && customName != null
            && "Vulcan".equalsIgnoreCase(ChatColor.stripColor(customName));
    }

    private static boolean isVulcan(MagmaCube entity) {
        String vulcanId = Entities.VULCAN.getKey().toString();
        boolean tagged = PersistentDataAPI.getOptionalString(entity, DemonicEntity.ENTITY_ID)
            .filter(vulcanId::equals)
            .isPresent();
        return tagged || isLegacyVulcanName(entity.getCustomName(), entity.isCustomNameVisible());
    }

    private static void markLoadedVulcansNonCollidable(Chunk chunk) {
        for (Entity entity : chunk.getEntities()) {
            if (entity instanceof MagmaCube magmaCube && isVulcan(magmaCube)) {
                magmaCube.setCollidable(false);
            }
        }
    }

}
