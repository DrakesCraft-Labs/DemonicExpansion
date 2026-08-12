package tsp.demonicexpansion.implementation.item.armor;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.recipe.Recipes;

public class DemonicLeggings extends DemonicArmor {

    public DemonicLeggings() {
        super(DemonicExpansion.getInstance().getItems().DEMONIC_LEGGINGS, Recipes.DEMONIC_LEGGINGS);
    }

    @Override
    public void whileWearing(LivingEntity entity) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 1));
    }

}
