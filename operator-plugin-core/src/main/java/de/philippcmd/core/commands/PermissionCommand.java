package de.philippcmd.core.commands;

import de.philippcmd.core.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermissionCommand implements CommandExecutor {

    private final Main plugin;

    public PermissionCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 3) {
            player.sendMessage("Usage: /permission <give|remove> <permission> <player>");
            return true;
        }

        String action = args[0].toLowerCase();
        String permission = args[1];
        String playerName = args[2];

        Player targetPlayer = plugin.getServer().getPlayer(playerName);
        if (targetPlayer == null || !targetPlayer.isOnline()) {
            player.sendMessage("Player '" + playerName + "' not found or is not online.");
            return true;
        }

        if (action.equals("give")) {
            givePermission(targetPlayer, permission);
            player.sendMessage("Permission " + permission + " has been given to " + playerName + ".");
        } else if (action.equals("remove")) {
            removePermission(targetPlayer, permission);
            player.sendMessage("Permission " + permission + " has been removed from " + playerName + ".");
        } else {
            player.sendMessage("Unknown action. Usage: /permission <give|remove> <permission> <player>");
        }

        return true;
    }

    private void givePermission(Player player, String permission) {
        PermissionAttachment attachment = player.addAttachment(plugin);
        attachment.setPermission(permission, true);
        plugin.getPlayerPermissions().put(player.getUniqueId(), attachment);
    }

    private void removePermission(Player player, String permission) {
        UUID uuid = player.getUniqueId();
        HashMap<UUID, PermissionAttachment> playerPermissions = plugin.getPlayerPermissions();
        if (playerPermissions.containsKey(uuid)) {
            PermissionAttachment attachment = playerPermissions.get(uuid);
            attachment.unsetPermission(permission);
            playerPermissions.remove(uuid);
            attachment.remove();
        }
    }
}



