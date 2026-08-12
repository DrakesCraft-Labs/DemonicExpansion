package tsp.demonicexpansion.implementation.item.armor;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.entity.LivingEntity;
import tsp.demonicexpansion.implementation.item.AbstractItem;
import tsp.demonicexpansion.implementation.recipe.DemonicRecipe;

public class AbstractArmor extends AbstractItem {

    public AbstractArmor(SlimefunItemStack item, DemonicRecipe recipe) {
        super(item, recipe);
    }

    public void whileWearing(LivingEntity entity) {}

}
