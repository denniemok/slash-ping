package com.battleasya;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final SlashPing plugin;

    public Config(SlashPing plugin) {
        this.plugin = plugin;
    }

    public String pingSelf;

    public String pingOthers;

    public double pingOffset;

    public String pingSyntax;

    public String reloadConfig;

    public String noPermission;

    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        pingSelf = config.getString("ping-self");
        pingOthers = config.getString("ping-others");
        pingOffset = config.getDouble("ping-offset");
        pingSyntax = config.getString("ping-syntax");
        reloadConfig = config.getString("reload-config");
        noPermission = config.getString("no-permission");

    }

}
