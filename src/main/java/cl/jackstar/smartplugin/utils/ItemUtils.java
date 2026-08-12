package cl.jackstar.smartplugin.utils;

import java.util.function.Consumer;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import tsp.demonicexpansion.DemonicExpansion;

/**
 * Enfriamiento de items activables.
 */
public final class ItemUtils {

    /**
     * El instante en que vuelve a estar disponible, guardado en el propio item.
     *
     * Se guarda ahi y no en un mapa en memoria a proposito: un mapa se vacia al reiniciar, y
     * entonces todo el mundo tiene sus items listos de golpe. Ademas el enfriamiento viaja con el
     * item, que es lo que se espera de un anillo que se puede prestar.
     */
    private static final NamespacedKey LISTO_EN =
            new NamespacedKey(DemonicExpansion.getInstance(), "listo_en");

    private ItemUtils() {}

    /**
     * Usa el item si no esta enfriando.
     *
     * @param item      el item que se activa
     * @param segundos  cuanto dura el enfriamiento
     * @param alUsar    que hacer si esta listo
     * @param siEnfria  recibe los segundos que faltan
     */
    public static void use(ItemStack item, int segundos,
                           Consumer<ItemStack> alUsar, Consumer<Long> siEnfria) {
        if (item == null) {
            return;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return;
        }

        PersistentDataContainer datos = meta.getPersistentDataContainer();
        long ahora = System.currentTimeMillis();
        Long listoEn = datos.get(LISTO_EN, PersistentDataType.LONG);

        if (listoEn != null && listoEn > ahora) {
            // Se redondea hacia arriba para no decir "0s" cuando aun falta medio segundo.
            siEnfria.accept((listoEn - ahora + 999) / 1000);
            return;
        }

        datos.set(LISTO_EN, PersistentDataType.LONG, ahora + segundos * 1000L);
        item.setItemMeta(meta);
        alUsar.accept(item);
    }
}
