package cl.jackstar.smartplugin.builder.item;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cl.jackstar.smartplugin.utils.StringUtils;

/**
 * Constructor de items encadenable.
 */
public class ItemBuilder {

    protected final ItemStack item;

    public ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    public ItemBuilder(ItemStack item) {
        this.item = item.clone();
    }

    public ItemBuilder setName(String nombre) {
        return editarMeta(meta -> meta.setDisplayName(StringUtils.colorize(nombre)));
    }

    public ItemBuilder setLore(String... lineas) {
        List<String> lore = Arrays.stream(lineas).map(StringUtils::colorize).toList();
        return editarMeta(meta -> meta.setLore(lore));
    }

    public ItemBuilder setAmount(int cantidad) {
        item.setAmount(cantidad);
        return this;
    }

    /**
     * Encantamiento sin las restricciones de Bukkit.
     *
     * Se usa {@code addUnsafeEnchantment} porque el addon pone velocidad del alma en unas botas de
     * cuero y niveles fuera de rango; el metodo seguro los rechazaria en silencio.
     */
    public ItemBuilder enchant(Enchantment encantamiento, int nivel) {
        item.addUnsafeEnchantment(encantamiento, nivel);
        return this;
    }

    /**
     * El brillo de item encantado sin encantamiento real.
     *
     * Se hace con {@code setEnchantmentGlintOverride}, que existe desde 1.20.5. Antes habia que
     * poner un encantamiento falso y esconderlo con un ItemFlag, lo que dejaba el encantamiento
     * de verdad en el item y se colaba en yunques y mesas de encantar.
     */
    public ItemBuilder setGlow(boolean brillo) {
        return editarMeta(meta -> meta.setEnchantmentGlintOverride(brillo));
    }

    /** Pasa a un constructor de armadura de cuero, que ademas admite color. */
    public LeatherArmorBuilder toLeatherArmorBuilder() {
        return new LeatherArmorBuilder(item);
    }

    public ItemStack build() {
        return item;
    }

    /** Evita repetir el ir y venir de getItemMeta/setItemMeta en cada metodo. */
    protected ItemBuilder editarMeta(java.util.function.Consumer<ItemMeta> cambio) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            cambio.accept(meta);
            item.setItemMeta(meta);
        }
        return this;
    }
}
