package cl.jackstar.smartplugin.handler;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import tsp.demonicexpansion.DemonicExpansion;

/**
 * Escucha que se registra sola al construirse.
 *
 * El addon las crea con {@code new EntityDamageListener();} y nada mas, sin llamar a registrar,
 * asi que el registro tiene que ocurrir en el constructor.
 */
public abstract class Handler implements Listener {

    protected Handler() {
        register(DemonicExpansion.getInstance());
    }

    protected Handler(JavaPlugin plugin) {
        register(plugin);
    }

    private void register(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}
