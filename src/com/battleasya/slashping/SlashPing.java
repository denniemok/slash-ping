package com.battleasya.slashping;

import com.battleasya.slashping.command.Ping;
import com.battleasya.slashping.command.Reload;
import com.battleasya.slashping.handler.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class SlashPing extends JavaPlugin {

    public Config config;

    public int version = 0; /* 0: Unknown, 1: Legacy, 2: Modern */

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("ping").setExecutor(new Ping(this));
        getCommand("pingreload").setExecutor(new Reload(this));

    }

}
