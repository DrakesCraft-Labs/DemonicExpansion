package cl.jackstar.smartplugin.utils;

import org.bukkit.ChatColor;

/**
 * Traduccion de codigos de color.
 */
public final class StringUtils {

    private StringUtils() {}

    /** Convierte los `&` en el caracter de seccion que entiende el cliente. */
    public static String colorize(String texto) {
        return texto == null ? null : ChatColor.translateAlternateColorCodes('&', texto);
    }
}
