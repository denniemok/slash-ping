<br>
<h3 align="center">Slash Ping</h3>
<p align="center">Enables to check in-game ping with /ping.</p>

<p align="center">
    <a href="https://github.com/denniemok/Slash-Ping/releases">Latest Release</a> •
    <a href="https://github.com/denniemok/Slash-Ping/wiki">User Guide</a> •
    <a href="https://github.com/denniemok/Slash-Ping/issues">Issue Tracker</a>
</p>

<p align="center">
    <img src="https://img.shields.io/badge/Version-1.0.4-green"> <img src="https://img.shields.io/badge/Spigot-1.8+-lightgrey"> <img src="https://img.shields.io/badge/License-MIT-blue"> <img src="https://img.shields.io/badge/Language-Java-yellow">
</p><br>

<hr>

### Introduction
This is a **minimalist** plugin with exactly one function: enables the checking of in-game ping with **/ping**. Nothing fancy or complicated is involved. What it does is only the simplest task you ever ask for, hence the performance and size. <br>

<hr>

### Major Highlights
- EssentialsX-style default message preset.
- Simple and lightweight; No unnecessary features other than /ping.
- Configure almost everything in config.yml. <br>
Modify ping values with multiplier and offset.
- Exemption to being a ping target is especially useful for admins to go completely invisible from normal players. <br>
Without introducing new exploits to your existing vanish system.
- Bypass exemption is designed for personnel who can see vanished users or have the need to administer at a high level
- Forward compatible to all versions from 1.8 and onwards.<br>
Utilised a reflection approach to retrieve ping values regardless of server versions. <br>

<hr>

### Ping Normalisation

This plugin allows ping to be adjusted before displaying to users. I offer this function simply because ping in Java does not only take into account network latency but also server-internal latency (i.e., processing delay). When the server gets laggier, the ping somehow goes insane as well. To avoid players from complaining about high ping due to occasional lag spikes (e.g., the notorious "SERVER LAGGGGG!!!!!!!!" whine), a way to (fake) normalise the values is provided.

`Round Down ( Original Ping Value * Multiplier + Offset )`

Round-down here means taking only the integral part from the final result.
Multiplier and offset are both configurable in config.yml.
Multiplier provides normalisation in multiplication (default 0.8) while offset in addition (default 0, allows negative decimal values).

<hr>

### Closest Match

Users no longer have to type in the full name of a ping target because the plugin is clever enough to find the closest match on the server! Isn't it good news for lazy people? (Although they can always use tab complete, which is better IMO...)

<hr>

### Runtime Requirements
- Java 8 or above
- Spigot 1.8 or above, or equivalent forks
- Permission plugin, preferably LuckPerms or PermissionsEx <br>

<hr>

### Build Dependencies
- Java 8
- Spigot API 1.8.8 R0.1
- Spigot API 1.20.1 R0.1<br>

<hr>

This project is released under the [MIT License](https://opensource.org/license/mit/).

