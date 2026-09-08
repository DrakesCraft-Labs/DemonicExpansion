package tsp.demonicexpansion.implementation.entity;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageEvent;
import tsp.demonicexpansion.DemonicExpansion;
import cl.jackstar.smartplugin.event.LivingEntityDamageByLivingEntityEvent;

import java.util.concurrent.ThreadLocalRandom;

public class Vulcan extends DemonicEntity {

    @Override
    public NamespacedKey getKey() {
        return new NamespacedKey(DemonicExpansion.getInstance(), "entity_vulcan");
    }

    @Override
    public Class<? extends LivingEntity> getEntityClass() {
        return MagmaCube.class;
    }

    @Override
    public double getMaxHealth() {
        return 60d;
    }

    @Override
    public double getArmor() {
        return 60d;
    }

    @Override
    public double getArmorToughness() {
        return 100d;
    }

    @Override
    public double getAttackDamage() {
        return 60d;
    }

    @Override
    public double getKnockbackResistance() {
        return 1d;
    }

    @Override
    public void onDamageReceived(LivingEntityDamageByLivingEntityEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            event.setCancelled(true);
            DemonicExpansion.getInstance().getLog().trace("Blocked vulcan projectile: " + event.getDamager().getName());
        }
    }

    @Override
    public void preSpawn(LivingEntity entity) {
        entity.setCollidable(false);
        ((MagmaCube) entity).setSize(ThreadLocalRandom.current().nextInt(3, 7)); // 3-6
    }

}
