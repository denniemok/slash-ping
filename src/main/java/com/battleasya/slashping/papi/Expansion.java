package com.battleasya.slashping.papi;

import com.battleasya.slashping.SlashPing;
import com.battleasya.slashping.handler.Util;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Expansion extends PlaceholderExpansion {

    private final SlashPing plugin;

    public Expansion(SlashPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "slashping";
    }

    @Override
    public String getAuthor() {
        return "Dennie";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true; /* avoid unregister on reload */
    }

    @Override
    public String onPlaceholderRequest(Player player, String param) {

        if (player == null) {
            return "-1";
        }

        if (param.equalsIgnoreCase("ping")) {
            return String.valueOf(Util.getPing(player
                    , plugin.config.pingMultiplier
                    , plugin.config.pingOffset
                    , plugin.config.pingMinimum));
        }

        return "-1"; /* Unknown */

    }

}
