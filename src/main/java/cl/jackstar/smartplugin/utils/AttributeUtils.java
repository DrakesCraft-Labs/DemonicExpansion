package cl.jackstar.smartplugin.utils;

import java.util.Map;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;

/**
 * Fija atributos base de una criatura.
 */
public final class AttributeUtils {

    private AttributeUtils() {}

    /**
     * Aplica cada atributo del mapa, saltandose los que la criatura no tenga.
     *
     * Lo de saltarse importa: {@code getAttribute} devuelve null para los atributos que esa
     * criatura no soporta, y no todas soportan todos. Sin la comprobacion, una sola criatura
     * rara aborta el resto de atributos y sale con la vida a medio poner.
     *
     * Ademas se iguala la vida actual al maximo. Bukkit no lo hace solo: subir MAX_HEALTH deja a
     * la criatura con la vida que tuviera, o sea recien aparecida y ya herida.
     */
    public static void setAttributes(LivingEntity entidad, Map<Attribute, Double> atributos) {
        Validate.notNull(entidad, "La criatura no puede ser nula!");

        for (Map.Entry<Attribute, Double> e : atributos.entrySet()) {
            AttributeInstance instancia = entidad.getAttribute(e.getKey());
            if (instancia != null && e.getValue() != null) {
                instancia.setBaseValue(e.getValue());
            }
        }

        AttributeInstance vida = entidad.getAttribute(Attribute.MAX_HEALTH);
        if (vida != null) {
            entidad.setHealth(vida.getValue());
        }
    }
}
