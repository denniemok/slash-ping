package com.battleasya.Cmd;

import com.battleasya.SlashPing;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class pingreload implements CommandExecutor {

    private final SlashPing plugin;

    public pingreload(SlashPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender.hasPermission("ping.reload")) {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.reloadConfig));
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
        }

        return true;

    }

}
