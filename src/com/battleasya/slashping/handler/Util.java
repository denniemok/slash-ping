package com.battleasya.slashping.handler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Util {

    private static Method getHandleMethod;

    private static Field pingField;

    public static int version = 0; /* 0: Unknown, 1: Legacy, 2: Modern */

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static boolean canPingSelf(CommandSender sender) {
        return sender.hasPermission("ping.self");
    }

    public static boolean canPingOthers(CommandSender sender) {
        return sender.hasPermission("ping.others");
    }

    public static int getPing(Player p, double m, double o) {

        switch (version) {
            case 1:
                return getPingLegacy(p, m, o);
            case 2:
                return getPingModern(p, m, o);
            default: /* unknown = 0 */
                int legacyResult = getPingLegacy(p, m, o); /* try legacy first */
                if (legacyResult == -1) {
                    version = 2;
                    return getPingModern(p, m, o);
                } else {
                    version = 1;
                    return legacyResult;
                }
        }

    }

    /* https://www.spigotmc.org/threads/get-player-ping-with-reflection.147773/ */
    /* credits to konsolas for the reflection system */
    public static int getPingLegacy(Player player, double multiplier, double offset) {

        try {

            if (getHandleMethod == null) {
                getHandleMethod = player.getClass().getDeclaredMethod("getHandle");
                getHandleMethod.setAccessible(true);
            }

            Object entityPlayer = getHandleMethod.invoke(player);

            if (pingField == null) {
                pingField = entityPlayer.getClass().getDeclaredField("ping");
                pingField.setAccessible(true);
            }

            int ping = (int) (pingField.getInt(entityPlayer) * multiplier + offset);

            return Math.max(ping, 0); /* greater of the 2 values */

        } catch (Exception e) {

            return -1;

        }

    }

    public static int getPingModern(Player player, double multiplier, double offset) {

        try {

            int ping = (int) (player.getPing() * multiplier + offset);

            return Math.max(ping, 0); /* greater of the 2 values */

        } catch (Exception e) {

            return -1;

        }

    }

}
