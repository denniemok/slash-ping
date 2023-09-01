<p>

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

<p>

<hr>

### Introduction
This is a **lightweight** plugin with exactly one function: enables the checking of in-game ping with **/ping**. Nothing fancy or complicated is involved. What it does is only the simplest task you ever ask for, hence the performance and size. <p>

<hr>

### Major Highlights
- EssentialsX-style default message preset.
- Simple and lightweight with no unnecessary features other than /ping.
- Highly configurable with built-in **HEX** colour support.
- Enables modification of ping values with **multiplier** and **offset**.
- Display normalised pings on **PlaceholderAPI** compatible plugins.
- Go completely intractable from ping with the exempt permission.
- Bypass target exemption to offer normal pinging at the admin level.
- Forward compatible with all **1.8+** versions.

<hr>

### 1. Ping Normalisation

Ping in Java does not only take into account network latency but also server-internal latency (i.e., processing delay). When the server gets a heavier load, the ping in relative also goes higher. To account for this, a way to normalise the ping values before displaying is provided.

**Normalised Value = Max ( Round ( Original Value * Multiplier + Offset ), 0 )**

Round here means taking only the integral part from the intermediate result. Multiplier normalises the values by multiplication while offset normalises by addition. Both parameters are configurable. <p>

### 2. Closest Name Match

Users no longer have to type in the full name of a ping target because the plugin is clever enough to find the closest match on the server based on the first few characters of a name on the server!<p>

### 3. HEX Colour Support

This plugin supports the colouring of chat messages with HEX codes on 1.16+ servers.<br>
Example: `"#e69296Your ping is #c8a2c8%ping% #e69296ms."`<p>

<hr>

### Runtime Requirements
- Java 8 or above
- Spigot 1.8 or above, or equivalent forks
- Permission plugin (Optional)
- PlaceholderAPI (Optional)

<hr>

### Build Dependencies
- Java 8
- Spigot API 1.20.1 R0.1
- PlaceholderAPI API 1.11.3

<hr>

This project is released under the [MIT License](https://opensource.org/license/mit/).

