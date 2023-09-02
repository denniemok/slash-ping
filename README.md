<br><br>

<p align="center">
    <img src="https://i.imgur.com/Ydt6CmB.png"><br>
    <img src="https://img.shields.io/badge/Version-1.0.6-green"> <img src="https://img.shields.io/badge/Spigot-1.8+-lightgrey"> <img src="https://img.shields.io/badge/License-MIT-blue"> <img src="https://img.shields.io/badge/Language-Java-yellow">
</p>

<p align="center">
    <a href="https://www.spigotmc.org/resources/112371/">Spigot Page</a> •
    <a href="https://github.com/denniemok/slash-ping/releases">Latest Release</a> •
    <a href="https://github.com/denniemok/slash-ping/wiki">User Guide</a> •
    <a href="https://github.com/denniemok/slash-ping/issues">Issue Tracker</a>
</p>

<br>

<hr>

### Introduction
This is a **lightweight** plugin with exactly one function: enables the checking of in-game ping with **/ping**. Nothing fancy or complicated is involved. What it does is only the simplest task you ever ask for, hence the performance and size.

Originally being part of [BattleAsya Utility](https://github.com/denniemok/battleasya-utility), now made available separately with enhanced configurability.

<hr>

### Major Highlights
- Comes with the well-known EssentialsX-style message preset.
- Works straight to the point with nothing unnecessary other than /ping.
- Supports **HEX codes** in message configuration on 1.16+ servers.
- Enables **modification of ping values** with simple parameters.
- Displays normalised pings on **PlaceholderAPI-compatible** plugins.
- Goes completely intractable from /ping with the exempt permission.
- Bypasses target exemption to offer normal pinging at the admin level.
- Proves to be forward compatible with all **1.8+** versions.

<hr>

### 1. Ping Normalisation

Ping in Java does not only take into account network latency but also server-internal latency (i.e., processing delay). Very often, you find yourself entering a 10 ms (from server list) server but end up getting 50 ms ping (with /ping) in-game. To combat this issue, a way to normalise the ping values before displaying them in chat (or elsewhere with PAPI) is provided.

**Normalised Value = Max ( Round ( Original Value * Multiplier + Offset ), Lower Bound )**

Round here means taking only the integral part from the intermediate result. Multiplier normalises the values by multiplication (default 0.8) while offset normalises by addition (default 0). The 2 parameters, together with the lower bound option, are made configurable in config.yml.

### 2. Closest Name Match

Users no longer have to type in the full name of a ping target because the plugin is clever enough to find the closest match on the server based on the first few characters of a name on the server!

### 3. HEX Colour Support

This plugin supports the colouring of chat messages with HEX codes on 1.16+ servers.<br>
Example: `"#e69296Your ping is #c8a2c8%ping% #e69296ms."`

### 4. PlaceholderAPI Support

Use the placeholder **%slashping_ping%** in any PlaceholderAPI-compatible plugins (e.g., your favourite TAB plugin) to display the normalised ping values.

<hr>

### Runtime Requirements
- Java 8 or above
- Spigot 1.8 or above, or equivalent forks
- Permission plugin (Optional)
- PlaceholderAPI (Optional)

<hr>

### Build Dependencies
- Java 8
- Spigot-API 1.20.1 R0.1
- PlaceholderAPI 1.11.3

<hr>

This project is released under the [MIT License](https://opensource.org/license/mit/).
