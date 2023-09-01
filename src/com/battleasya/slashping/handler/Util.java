package com.battleasya.slashping.handler;

import com.battleasya.slashping.SlashPing;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static Method getHandleMethod;

    private static Field pingField;

    public static int getPingApproach = 0; /* 0: Unknown, 1: Legacy, 2: Modern */

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(translate(message));
    }

    public static String translate(String message) {

        /* HEX code support starts at 1.16 */
        if (SlashPing.getServerVersion() >= 16) {

            Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String color = message.substring(matcher.start(), matcher.end());
                message = message.replace(color, ChatColor.of(color).toString());
                matcher = pattern.matcher(message);
            }

        }

        return ChatColor.translateAlternateColorCodes('&', message);

    }

    public static boolean canPingSelf(CommandSender sender) {
        return sender.hasPermission("ping.self");
    }

    public static boolean canPingOthers(CommandSender sender) {
        return sender.hasPermission("ping.others");
    }

    public static int getPing(Player p, double m, double o, int min) {

        switch (getPingApproach) {
            case 1:
                return getPingLegacy(p, m, o, min);
            case 2:
                return getPingModern(p, m, o, min);
            default: /* unknown = 0 */
                int legacyResult = getPingLegacy(p, m, o, min); /* try legacy first */
                if (legacyResult == -1) {
                    getPingApproach = 2;
                    return getPingModern(p, m, o, min);
                } else {
                    getPingApproach = 1;
                    return legacyResult;
                }
        }

    }

    /* https://www.spigotmc.org/threads/get-player-ping-with-reflection.147773/ */
    /* credits to konsolas for the reflection system */
    public static int getPingLegacy(Player player, double multiplier, double offset, int minimum) {

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

            return Math.max(ping, minimum); /* greater of the 2 values */

        } catch (Exception e) {

            return -1;

        }

    }

    public static int getPingModern(Player player, double multiplier, double offset, int minimum) {

        try {

            int ping = (int) (player.getPing() * multiplier + offset);

            return Math.max(ping, minimum); /* greater of the 2 values */

        } catch (Exception e) {

            return -1;

        }

    }

}
