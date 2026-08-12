package tsp.demonicexpansion.implementation.entity;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;
import cl.jackstar.smartplugin.builder.item.ItemBuilder;
import cl.jackstar.smartplugin.event.LivingEntityDamageByLivingEntityEvent;

import java.util.Arrays;

public class Hellhound extends DemonicEntity {

    @Override
    public NamespacedKey getKey() {
        return new NamespacedKey(DemonicExpansion.getInstance(), "entity_hellhound");
    }

    @Override
    public Class<? extends LivingEntity> getEntityClass() {
        return Wolf.class;
    }

    @Override
    public double getMaxHealth() {
        return 100d;
    }

    @Override
    public double getAttackDamage() {
        return 80d;
    }

    @Override
    public double getArmor() {
        return 100d;
    }

    @Override
    public double getArmorToughness() {
        return 50d;
    }

    @Override
    public double getKnockbackResistance() {
        return 0.5;
    }

    @Override
    public void tick(LivingEntity entity) {
        entity.addPotionEffects(Arrays.asList(
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40, 0, false, false),
                new PotionEffect(PotionEffectType.REGENERATION, 40, 1, false, false)
        ));

        // After killing his pray the wolf will stop being angry for some reason
        Wolf wolf = (Wolf) entity;
        wolf.setAngry(true);
    }

    @Override
    public void onDamageDealt(LivingEntityDamageByLivingEntityEvent event) {
        event.getVictim().setFireTicks(40);
    }

    @Override
    public void preSpawn(LivingEntity entity) {
        Wolf wolf = (Wolf) entity;
        wolf.setAdult();
        wolf.setTamed(true);
        wolf.setOwner(null);
        EntityEquipment equipment = wolf.getEquipment();
        if (equipment != null) {
            equipment.setBoots(new ItemBuilder(Material.LEATHER_BOOTS)
                    .enchant(Enchantment.SOUL_SPEED, 2)
                    .build());

            equipment.setBootsDropChance(0f);
        }
    }

}
