package me.verni.util;

import org.bukkit.ChatColor;

public class ChatUtil {
    private ChatUtil() {}
    public static String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
