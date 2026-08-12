package tsp.demonicexpansion.implementation.item.armor;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.recipe.Recipes;

public class DemonicChestplate extends DemonicArmor {

    public DemonicChestplate() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_CHESTPLATE, Recipes.DEMONIC_CHESTPLATE);
    }

    @Override
    public void whileWearing(LivingEntity entity) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20, 0));
    }

}
