package tsp.demonicexpansion.util;

import org.bukkit.Bukkit;
import cl.jackstar.smartplugin.logger.AbstractLogger;
import cl.jackstar.smartplugin.utils.StringUtils;

public class Logger extends AbstractLogger {

    public Logger(boolean debug) {
        super("DemonicExpansion", debug);
    }

    @Override
    public void log(LogLevel level, String message) {
        Bukkit.getConsoleSender().sendMessage(StringUtils.colorize("&7[&4&l" + getName() + "&7] " + level.getColor() + "[" + level.name() + "]: " + message + "\u001B[0m")); // Reset color after message
    }

}
