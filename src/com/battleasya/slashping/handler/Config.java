package com.battleasya.slashping.handler;

import com.battleasya.slashping.SlashPing;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final SlashPing plugin;

    public Config(SlashPing plugin) {
        this.plugin = plugin;
    }

    public String pingSelf;

    public String pingOthers;

    public String pingFailed;

    public double pingMultiplier;

    public double pingOffset;

    public String pingSyntax;

    public String reloadSyntax;

    public String noPermission;

    public String noPermissionSelf;

    public String noPermissionOthers;

    public String reloadConfig;

    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        pingSelf = config.getString("ping-self");
        pingOthers = config.getString("ping-others");

        pingFailed = config.getString("ping-failed");

        pingMultiplier = config.getDouble("ping-multiplier");
        pingOffset = config.getDouble("ping-offset");

        pingSyntax = config.getString("ping-syntax");
        reloadSyntax = config.getString("reload-syntax");

        noPermission = config.getString("no-permission");
        noPermissionSelf = config.getString("no-permission-self");
        noPermissionOthers = config.getString("no-permission-others");

        reloadConfig = config.getString("reload-config");

    }

}
