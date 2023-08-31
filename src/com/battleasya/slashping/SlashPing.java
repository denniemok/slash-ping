package com.battleasya.slashping;

import com.battleasya.slashping.bstats.Metrics;
import com.battleasya.slashping.command.Ping;
import com.battleasya.slashping.command.Reload;
import com.battleasya.slashping.handler.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class SlashPing extends JavaPlugin {

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        Objects.requireNonNull(getCommand("ping")).setExecutor(new Ping(this));
        Objects.requireNonNull(getCommand("pingreload")).setExecutor(new Reload(this));

        Metrics metrics = new Metrics(this, 19688);

    }

}
