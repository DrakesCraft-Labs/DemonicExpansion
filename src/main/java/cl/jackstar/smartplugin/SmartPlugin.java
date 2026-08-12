package cl.jackstar.smartplugin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Clase base de plugin con los enganches que usaba SmartPlugin.
 *
 * La unica diferencia con {@link JavaPlugin} es el nombre de los enganches: {@code onStart} en vez
 * de {@code onEnable} y {@code onStop} en vez de {@code onDisable}. Se mantienen los nombres para
 * no tocar el addon, que ya los implementa.
 */
public abstract class SmartPlugin extends JavaPlugin {

    /** Lo que en Bukkit seria onEnable. */
    public abstract void onStart();

    /** Lo que en Bukkit seria onDisable. Vacio por defecto: no todos los plugins lo necesitan. */
    public void onStop() {
        // sin nada que hacer salvo que se sobrescriba
    }

    @Override
    public final void onEnable() {
        onStart();
    }

    @Override
    public final void onDisable() {
        onStop();
    }

    /** La version declarada en el plugin.yml. */
    public String getPluginVersion() {
        return getDescription().getVersion();
    }
}
