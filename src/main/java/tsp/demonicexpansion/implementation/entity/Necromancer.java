package tsp.demonicexpansion.implementation.entity;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import tsp.demonicexpansion.DemonicExpansion;

public class Necromancer extends DemonicEntity {

    @Override
    public NamespacedKey getKey() {
        return new NamespacedKey(DemonicExpansion.getInstance(), "entity_necromancer");
    }

    @Override
    public Class<? extends LivingEntity> getEntityClass() {
        return PigZombie.class;
    }

    @Override
    public double getMaxHealth() {
        return 40d;
    }

    @Override
    public double getArmor() {
        return 40d;
    }

    @Override
    public void preSpawn(LivingEntity entity) {
        PigZombie zombie = (PigZombie) entity;
        zombie.setAngry(true);
        zombie.setAnger(Integer.MAX_VALUE); // They should always be angry
    }

}
