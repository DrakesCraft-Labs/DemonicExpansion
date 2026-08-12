package cl.jackstar.smartplugin.tasker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Tarea periodica.
 */
public interface Task extends Runnable {

    /** Cada cuanto se repite, en ticks. Un segundo por defecto. */
    default long getRepeatInterval() {
        return 20L;
    }

    /** Cuanto espera antes de la primera vuelta, en ticks. */
    default long getDelay() {
        return 20L;
    }

    /**
     * Programa la tarea en el hilo principal.
     *
     * Sincrona a proposito: las implementaciones recorren mundos, entidades y sus equipos, y nada
     * de eso se puede tocar fuera del hilo del servidor.
     */
    default void schedule(Plugin plugin) {
        Bukkit.getScheduler().runTaskTimer(plugin, this, getDelay(), getRepeatInterval());
    }
}
