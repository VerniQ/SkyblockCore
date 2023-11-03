package me.verni.commands;

import me.verni.SkyblockCoreConfig;
import me.verni.util.ChatUtil;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class LinkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        TextComponent discord = new TextComponent(SkyblockCoreConfig.get().getString("discordurl"));
        TextComponent www = new TextComponent(SkyblockCoreConfig.get().getString("wwwurl"));
        TextComponent itemshop = new TextComponent(SkyblockCoreConfig.get().getString("itemshopurl"));
        p.spigot().sendMessage(discord);
        p.spigot().sendMessage(www);
        p.spigot().sendMessage(itemshop);
        return false;
    }
}
