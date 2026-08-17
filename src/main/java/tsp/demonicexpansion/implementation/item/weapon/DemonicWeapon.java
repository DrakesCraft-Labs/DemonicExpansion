package tsp.demonicexpansion.implementation.item.weapon;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import tsp.demonicexpansion.implementation.item.AbstractItem;
import tsp.demonicexpansion.implementation.recipe.DemonicRecipe;
import tsp.smartplugin.event.LivingEntityDamageByLivingEntityEvent;

public class DemonicWeapon extends AbstractItem {

    public DemonicWeapon(SlimefunItemStack item, DemonicRecipe recipe) {
        super(item, recipe);
    }

    public void onHit(LivingEntityDamageByLivingEntityEvent event) {}

}
