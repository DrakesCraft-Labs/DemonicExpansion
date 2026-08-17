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
            "&ccorazón del diablo"
    );

    public final DemonicItemStack PENTECOSTAL_COIN = new DemonicItemStack(
            "PENTECOSTAL_COIN",
            Material.ORANGE_DYE,
            "&cmoneda de pentecostés",
            "",
            "&7Shift+Haga clic derecho para bloquear la posición en la parte superior del bloque actual(mundo principal & Inferior)",
            "&7Haga clic derecho y teletransporte al reino inferior por un tiempo y luego teletransporte de regreso.(60s)"
    );

    public final DemonicItemStack NAPALM = new DemonicItemStack(
            "NAPALM",
            Material.GREEN_DYE,
            "&2napalm"
    );

    // Armor

    public final DemonicItemStack DEMONIC_HELMET = new DemonicItemStack(
            "DEMONIC_HELMET",
            Material.NETHERITE_HELMET,
            "&cCasco demoniaco",
            "",
            "&6fisgonear: &7conseguir &9vision nocturna"
    );

    public final DemonicItemStack DEMONIC_CHESTPLATE = new DemonicItemStack(
            "DEMONIC_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&cCoraza de demonio",
            "",
            "&6Escondido por la noche: &7conseguir &6Resistente al fuego"
    );

    public final DemonicItemStack DEMONIC_LEGGINGS = new DemonicItemStack(
            "DEMONIC_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&cCalzas de demonio",
            "",
            "&6Buscando: &7conseguir &cregeneración de vida2"
    );

    public final DemonicItemStack DEMONIC_BOOTS = new DemonicItemStack(
            "DEMONIC_BOOTS",
            Material.NETHERITE_BOOTS,
            "&cbotas de demonio",
            "",
            "&6Caminante de magma: &7Convierte permanentemente el magma circundante en obsidiana!"
    );

    // Weapon

    public final DemonicItemStack DEVILS_RING = new DemonicItemStack(
            "DEVILS_RING",
            Material.RED_DYE,
            "&cAnillo de encantamiento",
            "",
            "&6Habilidades activas: &7Provoca que los enemigos cercanos queden cegados, debilitados y quemados.(60s)"
    );

    // Machines

    public final DemonicItemStack THERMAL_GENERATOR = new DemonicItemStack(
            "THERMAL_GENERATOR",
            HeadTexture.GENERATOR,
            "&cGenerador",
            "",
            "&7Puede generar electricidad en el Nether",
            "&7Debe colocarse encima del magma."
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
