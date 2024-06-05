plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

bukkit {
    name = "PermissionsSystem"
    main = "de.philippcmd.permissions.Main"
    apiVersion = "1.20"
    version = rootProject.version as String

    commands {
        register("permission") {
            description = "manages permissions of players"
            usage = "/permission <give|remove> <permission> <player>"
            aliases = listOf("perm")
            permission = "permissions.manage"
            permissionMessage = "You have no permission to run this command"
        }
    }
    permissions {
        register("permissions.manage") {
            description = "allows players to use /permission"
        }
    }
}