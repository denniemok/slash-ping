package com.battleasya.Cmd;

import com.battleasya.SlashPing;
import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {

    private final SlashPing plugin;

    public ping(SlashPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        try {

            if (args.length == 0) {
                if (sender.hasPermission("ping.self")) {
                    Player p = (Player) sender;
                    int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * plugin.config.pingOffset);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.pingSelf.replaceAll("%ping%", String.valueOf(ping))));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
                }
                return true;
            }

            if (args.length == 1) {
                if (sender.hasPermission("ping.others")) {
                    Player p = Bukkit.getPlayer(args[0]);
                    if (p != null && !VanishAPI.isInvisible(p)) {
                        int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * plugin.config.pingOffset);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.pingOthers.replaceAll("%name%", args[0]).replaceAll("%ping%", String.valueOf(ping))));
                        return true;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
                    return true;
                }
            }

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.pingSyntax));
            return true;

        } catch (Exception e) {
            return true;
        }

    }

}
