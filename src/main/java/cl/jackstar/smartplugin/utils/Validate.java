package cl.jackstar.smartplugin.utils;

/**
 * Comprobaciones de argumentos.
 */
public final class Validate {

    private Validate() {}

    public static void notNull(Object valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
