package cl.jackstar.smartplugin.builder.item;

import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Constructor de armadura de cuero: lo mismo que {@link ItemBuilder} y ademas el tinte.
 */
public class LeatherArmorBuilder extends ItemBuilder {

    public LeatherArmorBuilder(ItemStack item) {
        super(item);
    }

    /**
     * Tiñe la pieza.
     *
     * No hace nada si el item no es de cuero: solo esos llevan {@link LeatherArmorMeta}, y forzar
     * el cast reventaria en cuanto alguien encadenase esto sobre otra cosa.
     */
    public LeatherArmorBuilder color(Color color) {
        editarMeta(meta -> {
            if (meta instanceof LeatherArmorMeta cuero) {
                cuero.setColor(color);
            }
        });
        return this;
    }
}
