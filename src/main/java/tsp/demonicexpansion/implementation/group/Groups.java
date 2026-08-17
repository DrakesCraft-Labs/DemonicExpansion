package tsp.demonicexpansion.implementation.group;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import tsp.demonicexpansion.DemonicExpansion;

public final class Groups {

    private Groups() {}

    public static final ItemGroup MAIN = new ItemGroup(
            new NamespacedKey(DemonicExpansion.getInstance(), "group_main"),
            new CustomItemStack(Material.MAGMA_CREAM, "&4Expansión de encantamiento", "", "&7cosa")
    );

}
