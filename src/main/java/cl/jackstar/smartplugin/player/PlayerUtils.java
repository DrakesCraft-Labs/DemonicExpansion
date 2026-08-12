package cl.jackstar.smartplugin.player;

import org.bukkit.command.CommandSender;

import cl.jackstar.smartplugin.utils.StringUtils;

/**
 * Envio de mensajes con codigos de color.
 */
public final class PlayerUtils {

    private PlayerUtils() {}

    /** Acepta cualquier emisor, no solo jugadores: los comandos tambien responden a consola. */
    public static void sendMessage(CommandSender destino, String mensaje) {
        if (destino != null && mensaje != null) {
            destino.sendMessage(StringUtils.colorize(mensaje));
        }
    }
}
