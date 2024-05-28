package de.philippcmd.permissions;

import de.philippcmd.permissions.commands.PermissionCommand;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<>();
    public HashMap<UUID, PermissionAttachment> getPlayerPermissions() {
        return playerPermissions;
    }

    @Override
    public void onEnable() {
        getCommand("permission").setExecutor(new PermissionCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

