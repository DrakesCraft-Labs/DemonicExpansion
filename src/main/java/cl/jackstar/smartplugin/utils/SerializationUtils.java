package cl.jackstar.smartplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Guarda y recupera posiciones como texto.
 *
 * El addon las mete en el PersistentDataContainer de un item (la moneda pentecostal apunta a un
 * sitio al que teletransportarse), y ahi solo caben tipos simples.
 */
public final class SerializationUtils {

    private static final String SEP = ";";

    private SerializationUtils() {}

    /** Formato: mundo;x;y;z;yaw;pitch */
    public static String serializeLocation(Location loc) {
        Validate.notNull(loc, "La posicion no puede ser nula!");
        Validate.notNull(loc.getWorld(), "El mundo no puede ser nulo!");
        return String.join(SEP,
                loc.getWorld().getName(),
                String.valueOf(loc.getX()),
                String.valueOf(loc.getY()),
                String.valueOf(loc.getZ()),
                String.valueOf(loc.getYaw()),
                String.valueOf(loc.getPitch()));
    }

    /**
     * Devuelve null si el texto no encaja o si el mundo ya no existe.
     *
     * Lo segundo pasa de verdad: si se borra un mundo, los items que apuntaban a el siguen por
     * ahi. Antes reventar con NPE al usarlos que teletransportar a ninguna parte.
     */
    public static Location deserializeLocation(String texto) {
        if (texto == null) {
            return null;
        }
        String[] p = texto.split(SEP);
        if (p.length < 4) {
            return null;
        }
        World mundo = Bukkit.getWorld(p[0]);
        if (mundo == null) {
            return null;
        }
        try {
            return new Location(mundo,
                    Double.parseDouble(p[1]), Double.parseDouble(p[2]), Double.parseDouble(p[3]),
                    p.length > 4 ? Float.parseFloat(p[4]) : 0f,
                    p.length > 5 ? Float.parseFloat(p[5]) : 0f);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
