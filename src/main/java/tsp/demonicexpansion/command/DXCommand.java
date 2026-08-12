package tsp.demonicexpansion.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tsp.demonicexpansion.implementation.entity.Entities;
import cl.jackstar.smartplugin.command.SmartCommand;
import cl.jackstar.smartplugin.player.PlayerUtils;

public class DXCommand extends SmartCommand {

    public DXCommand() {
        super("dx", "dx.command.use", "&cNo permission!");
    }

    @Override
    public void handle(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            PlayerUtils.sendMessage(sender, "&cOnly for in-game players!");
            return;
        }
        if (args.length == 0) {
            PlayerUtils.sendMessage(player, "&cYou need to specify an entity! Usage: &e/dx <entity>");
        }

        String name = args[0];
        if (name.equalsIgnoreCase("necromancer")) {
            Entities.NECROMANCER.spawn(player.getLocation());
        } else if (name.equalsIgnoreCase("reaper")) {
            Entities.REAPER.spawn(player.getLocation());
        } else if (name.equalsIgnoreCase("vulcan")) {
            Entities.VULCAN.spawn(player.getLocation());
        } else if (name.equalsIgnoreCase("hellhound")) {
            Entities.HELLHOUND.spawn(player.getLocation());
        } else {
            PlayerUtils.sendMessage(player, "&cUnknown entity: &e" + name);
        }
    }

}
