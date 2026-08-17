package tsp.demonicexpansion.task;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.armor.AbstractArmor;
import tsp.smartplugin.tasker.Task;

/**
 * This task ticks all {@link AbstractArmor armor pieces}.
 *
 * @author TheSilentPro (Silent)
 */
public class ArmorTask implements Task {

    @Override
    public void run() {
        for (World world : Bukkit.getWorlds()) {
            for (LivingEntity entity : world.getLivingEntities()) {
                EntityEquipment equipment = entity.getEquipment();
                if (equipment != null) {
                    ItemStack[] contents = equipment.getArmorContents();
                    for (ItemStack armor : contents) {
                        SlimefunItem item = SlimefunItem.getByItem(armor);
                        if (item instanceof AbstractArmor a) {
                            a.whileWearing(entity);
                        }
                    }
                }
            }
        }
    }

    @Override
    public long getRepeatInterval() {
        return DemonicExpansion.getInstance().getConfig().getLong("ticker.armor", 1);
    }

}
