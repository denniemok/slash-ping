package com.battleasya.slashping.command;

import com.battleasya.slashping.SlashPing;
import com.battleasya.slashping.handler.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    private final SlashPing plugin;

    public Ping(SlashPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("This is a player-only command!");
            return true;
        }

        boolean canPingSelf = Util.canPingSelf(sender);
        boolean canPingOthers = Util.canPingOthers(sender);

        if (!canPingSelf && !canPingOthers) {
            Util.sendMessage(sender, plugin.config.noPermission);
            return true;
        }

        if (args.length == 0) {

            if (canPingSelf) {

                Player player = Bukkit.getPlayer(sender.getName());

                String ping = String.valueOf(Util.getPing(player
                        , plugin.config.pingMultiplier
                        , plugin.config.pingOffset
                        , plugin.config.pingMinimum));

                Util.sendMessage(sender, plugin.config.pingSelf
                        .replace("%ping%", ping));

            } else {

                Util.sendMessage(sender, plugin.config.noPermissionSelf);

            }

            return true;

        }

        if (args.length == 1) {

            if (canPingOthers) {

                Player player = Bukkit.getPlayer(args[0]);

                if (player != null && (!player.hasPermission("ping.exempt")
                        || sender.hasPermission("ping.ignoreexempt"))) {

                    String playerName = player.getName();

                    String ping = String.valueOf(Util.getPing(player
                            , plugin.config.pingMultiplier
                            , plugin.config.pingOffset
                            , plugin.config.pingMinimum));

                    Util.sendMessage(sender, plugin.config.pingOthers
                            .replace("%name%", playerName)
                            .replace("%ping%", ping));

                } else {

                    Util.sendMessage(sender, plugin.config.pingFailed);

                }

            } else {

                Util.sendMessage(sender, plugin.config.noPermissionOthers);

            }

            return true;

        }

        Util.sendMessage(sender, plugin.config.pingSyntax);
        return true;

    }

}