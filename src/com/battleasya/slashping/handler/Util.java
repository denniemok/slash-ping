package com.battleasya.slashping.handler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Util {

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
