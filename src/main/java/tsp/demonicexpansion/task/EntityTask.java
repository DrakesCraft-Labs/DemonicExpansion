package tsp.demonicexpansion.task;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.world.EntitiesLoadEvent;
import org.bukkit.event.world.EntitiesUnloadEvent;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.entity.DemonicEntity;
import cl.jackstar.smartplugin.tasker.Task;
import cl.jackstar.smartplugin.handler.Handler;

/**
 * This task ticks all {@link DemonicEntity DemonicEntities}.
 *
 * @author TheSilentPro (Silent)
 */
public class EntityTask extends Handler implements Task {

    private static final long MINIMUM_INTERVAL_TICKS = 10L;

    public EntityTask() {
        // Bootstrap only once. Afterwards chunk lifecycle events maintain the active registry.
        for (World world : Bukkit.getWorlds()) {
            for (LivingEntity entity : world.getLivingEntities()) {
                DemonicExpansion.getInstance().getEntityManager().track(entity);
            }
        }
    }

    @Override
    public void run() {
        DemonicExpansion.getInstance().getEntityManager().tickActiveEntities();
    }

    @EventHandler
    public void onEntitiesLoad(EntitiesLoadEvent event) {
        for (org.bukkit.entity.Entity entity : event.getEntities()) {
            if (entity instanceof LivingEntity livingEntity) {
                DemonicExpansion.getInstance().getEntityManager().track(livingEntity);
            }
        }
    }

    @EventHandler
    public void onEntitiesUnload(EntitiesUnloadEvent event) {
        for (org.bukkit.entity.Entity entity : event.getEntities()) {
            DemonicExpansion.getInstance().getEntityManager().untrack(entity.getUniqueId());
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        DemonicExpansion.getInstance().getEntityManager().untrack(event.getEntity().getUniqueId());
    }

    @Override
    public long getRepeatInterval() {
        long configured = DemonicExpansion.getInstance().getConfig().getLong("ticker.entity", 20L);
        return normalizeInterval(configured);
    }

    static long normalizeInterval(long configured) {
        return Math.max(MINIMUM_INTERVAL_TICKS, configured);
    }

}
