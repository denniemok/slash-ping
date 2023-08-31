<br><br>

<p align="center">
    <img src="https://i.imgur.com/BM3lYc1.png"><br>
    <img src="https://img.shields.io/badge/Version-1.0.5-green"> <img src="https://img.shields.io/badge/Spigot-1.8+-lightgrey"> <img src="https://img.shields.io/badge/License-MIT-blue"> <img src="https://img.shields.io/badge/Language-Java-yellow">
</p>

<p align="center">
    Enables to check in-game ping with /ping.<br>
    <a href="https://www.spigotmc.org/resources/112371/">Spigot Page</a> •
    <a href="https://github.com/denniemok/Slash-Ping/releases">Latest Release</a> •
    <a href="https://github.com/denniemok/Slash-Ping/wiki">User Guide</a> •
    <a href="https://github.com/denniemok/Slash-Ping/issues">Issue Tracker</a>
</p><br>

<hr>

### Introduction
This is a **lightweight** plugin with exactly one function: enables the checking of in-game ping with **/ping**. Nothing fancy or complicated is involved. What it does is only the simplest task you ever ask for, hence the performance and size. <br>

<img src="https://i.imgur.com/DfEwsZ1.png"><br>

<hr>

### Major Highlights
- EssentialsX-style default message preset.
- Simple and lightweight; No unnecessary features other than /ping.
- Configure **almost everything** in config.yml, **HEX colour** support included.
- Modify ping values with **multiplier** and **offset**.
- Exemption to being a ping target.<br>
_Especially useful for admins to go completely invisible from normal players without conflicting much with the vanish system._
- Bypass exemption to being a ping target. <br>
_Designed for personnel who can see vanished users or have the need to administer at a high level._
- Forward compatible to all versions from **1.8 and onwards**.<br>
_Utilised a reflection approach to retrieve ping values regardless of server versions._ <br>

<hr>

### Ping Normalisation

Ping in Java does not only take into account network latency but also server-internal latency (i.e., processing delay). When the server gets a heavier load, the ping in relative also goes higher. To account for this, a way to normalise the ping values before displaying is provided.

**Normalised Value = Max ( Round Down ( Original Value * Multiplier + Offset ), 0 )**

Round-down here means taking only the integral part from the final result. Multiplier normalises by multiplication (default 0.8) while offset by addition (default 0, allows negative decimal values). Both parameters are configurable in config.yml. <p>

0 is the absolute minimum. -1 indicates errors. <br>

<hr>

### Closest Match

Users no longer have to type in the full name of a ping target because the plugin is clever enough to find the closest match (based on the first few characters of a name) on the server! Isn't it good news for lazy people?

<img src="https://i.imgur.com/P8V5qAu.png"><br>

<hr>

### HEX Color

This plugin supports the colouring of chat messages with HEX codes on 1.16+ servers.

Example:
`ping-self: "#e69296Your ping is #c8a2c8%ping% #e69296ms."`

<img src="https://i.imgur.com/ZzgUF6B.png"><br>

<hr>

### Runtime Requirements
- Java 8 or above
- Spigot 1.8 or above, or equivalent forks
- Permission plugin, preferably LuckPerms or PermissionsEx <br>

<hr>

### Build Dependencies
- Java 8
- Spigot API 1.8.8 R0.1 Shaded
- Spigot API 1.20.1 R0.1 Shaded

Spigot APIs can be obtained from [here](https://hub.spigotmc.org/nexus/content/repositories/snapshots/org/spigotmc/spigot-api/). <br>

<hr>

This project is released under the [MIT License](https://opensource.org/license/mit/).

