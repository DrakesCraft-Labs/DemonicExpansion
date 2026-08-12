package tsp.demonicexpansion.implementation.item.misc;

import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.AbstractItem;
import tsp.demonicexpansion.implementation.recipe.Recipes;

public class Napalm extends AbstractItem {

    public Napalm() {
        super(DemonicExpansion.getInstance().getItems().NAPALM, Recipes.NAPALM);
    }

}
