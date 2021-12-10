package com.josemarcellio.antipluginstealer.utils;

import org.bukkit.ChatColor;

public class Utils {
    public static String getColor(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
