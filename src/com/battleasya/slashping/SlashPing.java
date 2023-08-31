package com.battleasya.slashping;

import com.battleasya.slashping.bstats.Metrics;
import com.battleasya.slashping.command.Ping;
import com.battleasya.slashping.command.Reload;
import com.battleasya.slashping.handler.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class SlashPing extends JavaPlugin {

    public Config config;

    public static int version;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        Objects.requireNonNull(getCommand("ping")).setExecutor(new Ping(this));
        Objects.requireNonNull(getCommand("pingreload")).setExecutor(new Reload(this));

        new Metrics(this, 19688);
        getLogger().info("Starting Metrics. Opt-out using the global bStats config.");

        /* e.g., 1.14-R0.1-SNAPSHOT */
        try {
            version = Integer.parseInt(getServer().getBukkitVersion().split("-")[0].split("\\.")[1]);
        } catch (Exception e) {
            version = 8;
        }

    }

    public static int getServerVersion() {
        return version;
    }

}
