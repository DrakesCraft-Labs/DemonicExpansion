package cl.jackstar.smartplugin.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**
 * Sorteos por porcentaje.
 */
public final class NumberUtils {

    private NumberUtils() {}

    /**
     * Tira un porcentaje y llama a una rama u otra.
     *
     * El sorteo es {@code tirada < porcentaje} sobre [0,100), de modo que 0 no acierta nunca y
     * 100 acierta siempre. El addon lo usa para decidir si una criatura vanilla se sustituye por
     * una demoniaca al aparecer.
     *
     * @param porcentaje probabilidad de acierto, de 0 a 100
     * @param acierto    que hacer si sale
     * @param fallo      que hacer si no sale
     */
    public static void chance(int porcentaje, Consumer<Integer> acierto, Consumer<Integer> fallo) {
        int tirada = ThreadLocalRandom.current().nextInt(100);
        if (tirada < porcentaje) {
            acierto.accept(tirada);
        } else {
            fallo.accept(tirada);
        }
    }
}
