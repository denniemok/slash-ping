package com.battleasya;

import com.battleasya.Cmd.Ping;
import com.battleasya.Cmd.Reload;
import com.battleasya.Hdlr.Config;
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
