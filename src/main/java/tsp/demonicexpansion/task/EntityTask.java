package tsp.demonicexpansion.task;

import com.github.drakescraft_labs.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.entity.DemonicEntity;
import tsp.smartplugin.tasker.Task;

/**
 * This task ticks all {@link DemonicEntity DemonicEntities}.
 *
 * @author TheSilentPro (Silent)
 */
public class EntityTask implements Task {

    @Override
    public void run() {
        for (World world : Bukkit.getWorlds()) {
            for (LivingEntity entity : world.getLivingEntities()) {
                PersistentDataAPI.getOptionalString(entity, DemonicEntity.ENTITY_ID)
                        .flatMap(id -> DemonicExpansion.getInstance().getEntityManager().getEntity(NamespacedKey.fromString(id)))
                        .ifPresent(e -> e.tick(entity));
            }
        }
    }

    @Override
    public long getRepeatInterval() {
        return DemonicExpansion.getInstance().getConfig().getLong("ticker.entity", 1);
    }

}
