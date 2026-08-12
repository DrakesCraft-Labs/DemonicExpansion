package tsp.demonicexpansion.implementation.entity;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.inventory.EntityEquipment;
import tsp.demonicexpansion.DemonicExpansion;
import cl.jackstar.smartplugin.builder.item.ItemBuilder;

public class Reaper extends DemonicEntity {

    @Override
    public NamespacedKey getKey() {
        return new NamespacedKey(DemonicExpansion.getInstance(), "entity_reaper");
    }

    @Override
    public Class<? extends LivingEntity> getEntityClass() {
        return WitherSkeleton.class;
    }

    @Override
    public double getMaxHealth() {
        return 60d;
    }

    @Override
    public double getArmor() {
        return 40d;
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
    public void preSpawn(LivingEntity entity) {
        EntityEquipment equipment = entity.getEquipment();
        if (equipment != null) {
            equipment.setHelmet(new ItemBuilder(Material.LEATHER_HELMET)
                    .setGlow(true)
                    .toLeatherArmorBuilder()
                    .color(Color.BLACK)
                    .build());
            equipment.setChestplate(new ItemBuilder(Material.LEATHER_CHESTPLATE)
                    .setGlow(true)
                    .toLeatherArmorBuilder()
                    .color(Color.BLACK)
                    .build());
            equipment.setLeggings(new ItemBuilder(Material.LEATHER_LEGGINGS)
                    .setGlow(true)
                    .toLeatherArmorBuilder()
                    .color(Color.BLACK)
                    .build());
            equipment.setBoots(new ItemBuilder(Material.LEATHER_BOOTS)
                    .setGlow(true)
                    .enchant(Enchantment.SOUL_SPEED, 1)
                    .toLeatherArmorBuilder()
                    .color(Color.BLACK)
                    .build());

            equipment.setItemInMainHand(new ItemBuilder(Material.NETHERITE_SWORD)
                    .enchant(Enchantment.SHARPNESS, 3)
                    .build());

            equipment.setHelmetDropChance(0f);
            equipment.setChestplateDropChance(0f);
            equipment.setLeggingsDropChance(0f);
            equipment.setBootsDropChance(0f);
            equipment.setItemInMainHandDropChance(0f);
        }
    }

}
