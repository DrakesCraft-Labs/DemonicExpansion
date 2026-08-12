package cl.jackstar.smartplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import cl.jackstar.smartplugin.player.PlayerUtils;

/**
 * Comando con permiso y mensaje de rechazo propios.
 */
public abstract class SmartCommand implements CommandExecutor {

    private final String nombre;
    private final String permiso;
    private final String sinPermiso;

    protected SmartCommand(String nombre, String permiso, String sinPermiso) {
        this.nombre = nombre;
        this.permiso = permiso;
        this.sinPermiso = sinPermiso;
    }

    /** Lo que hace el comando una vez comprobado el permiso. */
    public abstract void handle(CommandSender emisor, String[] args);

    /**
     * Engancha el comando al plugin.
     *
     * Si el comando no esta declarado en el plugin.yml, {@code getCommand} devuelve null y Bukkit
     * no da ningun aviso: el comando simplemente no responderia. Se avisa por consola para que no
     * se quede en un misterio silencioso.
     */
    public void register(JavaPlugin plugin) {
        PluginCommand comando = plugin.getCommand(nombre);
        if (comando == null) {
            plugin.getLogger().warning("El comando /" + nombre + " no esta declarado en plugin.yml;"
                    + " no se ha registrado.");
            return;
        }
        comando.setExecutor(this);
    }

    @Override
    public final boolean onCommand(CommandSender emisor, Command comando, String etiqueta, String[] args) {
        if (permiso != null && !permiso.isEmpty() && !emisor.hasPermission(permiso)) {
            PlayerUtils.sendMessage(emisor, sinPermiso);
            return true;
        }
        handle(emisor, args);
        return true;
    }

    public String getName() {
        return nombre;
    }

    public String getPermission() {
        return permiso;
    }
}
