package tsp.demonicexpansion.util;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    @Nonnull
    public static List<LivingEntity> getNearbyLivingEntities(Entity entity, int x, int y, int z) {
        Validate.notNull(entity, "Entity can not be null!");

        List<LivingEntity> entities = new ArrayList<>();
        for (Entity nearby : entity.getNearbyEntities(x, y, z)) {
            if (nearby instanceof LivingEntity livingEntity
                    && !(livingEntity instanceof ArmorStand)) { // We do not want armor stands and such
                entities.add(livingEntity);
            }
        }

        return entities;
    }

    @Nonnull
    public static List<LivingEntity> getNearbyLivingEntities(Entity entity, int radius) {
        return getNearbyLivingEntities(entity, radius, radius, radius);
    }

}
