package com.battleasya.slashping;

import com.battleasya.slashping.bstats.Metrics;
import com.battleasya.slashping.command.Ping;
import com.battleasya.slashping.command.Reload;
import com.battleasya.slashping.handler.Config;
import com.battleasya.slashping.papi.Expansion;
import org.bukkit.plugin.java.JavaPlugin;

public class SlashPing extends JavaPlugin {

    public Config config;

    public static int version;

    @Override
    public void onEnable() {

        /* generate config if not exist */
        saveDefaultConfig();

        /* register config */
        config = new Config(this);
        config.fetchConfig();

        /* register command */
        getCommand("ping").setExecutor(new Ping(this));
        getCommand("pingreload").setExecutor(new Reload(this));

        /* register papi expansion */
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Expansion(this).register();
        }

        /* register bstats */
        new Metrics(this, 19688);
        getLogger().info("Starting Metrics. Opt-out using the global bStats config.");

        /* e.g. 1.20.1-R0.1-SNAPSHOT */
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
