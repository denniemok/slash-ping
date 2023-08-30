package com.battleasya.slashping.command;

import com.battleasya.slashping.SlashPing;
import com.battleasya.slashping.handler.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private final SlashPing plugin;

    public Reload(SlashPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission("ping.reload")) {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            Util.sendMessage(sender, plugin.config.reloadConfig);
        } else {
            Util.sendMessage(sender, plugin.config.noPermission);
        }

        return true;

    }

}
