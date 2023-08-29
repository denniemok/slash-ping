package com.battleasya;

import com.battleasya.command.Ping;
import com.battleasya.command.Reload;
import com.battleasya.handler.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class SlashPing extends JavaPlugin {

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("ping").setExecutor(new Ping(this));
        getCommand("pingreload").setExecutor(new Reload(this));

    }

}
