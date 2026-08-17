package tsp.demonicexpansion.implementation.research;

import tsp.demonicexpansion.DemonicExpansion;
import tsp.demonicexpansion.implementation.item.Items;

public class Researches {

    public final DemonicResearch HELL = new DemonicResearch(
            "hell",
            "El diablo ruge en el infierno.",
            30
    );

    public void setup() {
        Items items = DemonicExpansion.getInstance().getItems();
        HELL.addItems(
                items.DEMONIC_ESSENCE.getItem(),
                items.DEMONIC_HELMET.getItem(), items.DEMONIC_CHESTPLATE.getItem(), items.DEMONIC_LEGGINGS.getItem(), items.DEMONIC_BOOTS.getItem(),
                items.PENTECOSTAL_COIN.getItem(),
                items.THERMAL_GENERATOR.getItem(),
                items.DEVILS_RING.getItem(),
                items.NAPALM.getItem()
        );
        HELL.register();
    }

}
