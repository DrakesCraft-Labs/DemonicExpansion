package tsp.demonicexpansion.implementation.item;

import com.github.drakescraft_labs.slimefun4.utils.HeadTexture;
import org.bukkit.Material;
import tsp.demonicexpansion.implementation.item.armor.DemonicBoots;
import tsp.demonicexpansion.implementation.item.armor.DemonicChestplate;
import tsp.demonicexpansion.implementation.item.armor.DemonicHelmet;
import tsp.demonicexpansion.implementation.item.armor.DemonicLeggings;
import tsp.demonicexpansion.implementation.item.generator.ThermalGenerator;
import tsp.demonicexpansion.implementation.item.misc.DemonicEssence;
import tsp.demonicexpansion.implementation.item.misc.Napalm;
import tsp.demonicexpansion.implementation.item.misc.PentecostalCoin;
import tsp.demonicexpansion.implementation.item.weapon.DevilsRing;

/**
 * Contains all the items that are used by this addon.
 */
public class Items {

    // Misc

    public final DemonicItemStack DEMONIC_ESSENCE = new DemonicItemStack(
            "DEMONIC_ESSENCE",
            Material.PURPLE_DYE,
            "&cCorazón de Demonio"
    );

    public final DemonicItemStack PENTECOSTAL_COIN = new DemonicItemStack(
            "PENTECOSTAL_COIN",
            Material.ORANGE_DYE,
            "&cMoneda de Pentecostés",
            "",
            "&7Shift+clic derecho: fija la posición sobre el bloque (Mundo normal y Nether)",
            "&7Clic derecho: te lleva al Nether y te devuelve al rato (60s)"
    );

    public final DemonicItemStack NAPALM = new DemonicItemStack(
            "NAPALM",
            Material.GREEN_DYE,
            "&2Napalm"
    );

    // Armor

    public final DemonicItemStack DEMONIC_HELMET = new DemonicItemStack(
            "DEMONIC_HELMET",
            Material.NETHERITE_HELMET,
            "&cCasco Demoníaco",
            "",
            "&6Atisbo: &7te da &9Visión Nocturna"
    );

    public final DemonicItemStack DEMONIC_CHESTPLATE = new DemonicItemStack(
            "DEMONIC_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&cPeto Demoníaco",
            "",
            "&6Ocultación: &7te da &6Resistencia al Fuego"
    );

    public final DemonicItemStack DEMONIC_LEGGINGS = new DemonicItemStack(
            "DEMONIC_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&cGrebas Demoníacas",
            "",
            "&6Búsqueda: &7te da &cRegeneración II"
    );

    public final DemonicItemStack DEMONIC_BOOTS = new DemonicItemStack(
            "DEMONIC_BOOTS",
            Material.NETHERITE_BOOTS,
            "&cBotas Demoníacas",
            "",
            "&6Caminante de Lava: &7convierte en obsidiana la lava de alrededor, para siempre"
    );

    // Weapon

    public final DemonicItemStack DEVILS_RING = new DemonicItemStack(
            "DEVILS_RING",
            Material.RED_DYE,
            "&cAnillo Demoníaco",
            "",
            "&6Habilidad activa: &7ciega, debilita y prende fuego a los enemigos cercanos (60s)"
    );

    // Machines

    public final DemonicItemStack THERMAL_GENERATOR = new DemonicItemStack(
            "THERMAL_GENERATOR",
            HeadTexture.GENERATOR,
            "&cGenerador Demoníaco",
            "",
            "&7Genera energía en el Nether",
            "&7Hay que colocarlo sobre lava"
    );

    public void setup() {
        new DemonicEssence().registerDefault();
        new DemonicHelmet().registerDefault();
        new DemonicChestplate().registerDefault();
        new DemonicLeggings().registerDefault();
        new DemonicBoots().registerDefault();
        new PentecostalCoin().registerDefault();
        new Napalm().registerDefault();
        new DevilsRing().registerDefault();
        new ThermalGenerator().registerDefault();
    }

}
