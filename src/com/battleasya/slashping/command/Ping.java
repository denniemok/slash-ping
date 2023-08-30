package com.battleasya.slashping.command;

import com.battleasya.slashping.SlashPing;
import com.battleasya.slashping.handler.Util;
import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
// DEPRECATED: import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ping implements CommandExecutor {

    private final SlashPing plugin;

    public Ping(SlashPing plugin) {
        this.plugin = plugin;
    }

    private Method getHandleMethod;

    private Field pingField;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length == 0) {

            if (sender.hasPermission("ping.self")) {

                Player p = Bukkit.getPlayer(sender.getName());

                String ping = String.valueOf(getPing(p));
                // DEPRECATED: int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * plugin.config.pingOffset);

                Util.sendMessage(sender, plugin.config.pingSelf
                        .replaceAll("%ping%", ping));

            } else {

                Util.sendMessage(sender, plugin.config.noPermission);

            }

            return true;

        }

        if (args.length == 1) {

            if (sender.hasPermission("ping.others")) {

                Player p = Bukkit.getPlayer(args[0]);

                if (p != null && !p.hasPermission("ping.exempt") && !VanishAPI.isInvisible(p)) {

                    String playerName = p.getName();
                    String ping = String.valueOf(getPing(p));
                    // DEPRECATED: int ping = (int) (((((CraftPlayer) p).getHandle()).ping) * plugin.config.pingOffset);

                    Util.sendMessage(sender, plugin.config.pingOthers
                            .replaceAll("%name%", playerName)
                            .replaceAll("%ping%", ping));

                } else {

                    Util.sendMessage(sender, plugin.config.pingFailed);

                }

            } else {

                Util.sendMessage(sender, plugin.config.noPermission);

            }

            return true;

        }

        Util.sendMessage(sender, plugin.config.incorrectSyntax);
        return true;

    }

    /* https://www.spigotmc.org/threads/get-player-ping-with-reflection.147773/ */
    /* credits to konsolas for the lazily loaded system */
    public int getPing(Player p) {

        try {

            if (getHandleMethod == null) {
                getHandleMethod = p.getClass().getDeclaredMethod("getHandle");
                getHandleMethod.setAccessible(true);
            }

            Object entityPlayer = getHandleMethod.invoke(p);

            if (pingField == null) {
                pingField = entityPlayer.getClass().getDeclaredField("ping");
                pingField.setAccessible(true);
            }

            return (int) (pingField.getInt(entityPlayer) * plugin.config.pingMultiplier + plugin.config.pingOffset);

        } catch (Exception e) {

            return -1;

        }

    }

}
