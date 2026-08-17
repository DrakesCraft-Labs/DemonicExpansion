package tsp.demonicexpansion.implementation.recipe;

import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

public record DemonicRecipe(RecipeType type, ItemStack[] recipe) {}