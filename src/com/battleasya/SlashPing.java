package com.battleasya;

import com.battleasya.Cmd.ping;
import com.battleasya.Cmd.pingreload;
import org.bukkit.plugin.java.JavaPlugin;

public class SlashPing extends JavaPlugin {

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("ping").setExecutor(new ping(this));
        getCommand("pingreload").setExecutor(new pingreload(this));

    }

}
