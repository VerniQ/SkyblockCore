package me.verni.commands;

import me.verni.SkyblockCoreConfig;
import me.verni.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ClearChatCommand  implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
            Player p = (Player) sender;
            if(!p.hasPermission("skyblock.chatclear")){
                p.sendMessage("&cNie posiadasz uprawnień!");
                return false;
            }
        for(Player pl: Bukkit.getOnlinePlayers()){
            pl.sendMessage(" \n".repeat(256));
            pl.sendMessage(ChatUtil.hex("&#", "", SkyblockCoreConfig.get().getString("prefix")) + " " + ChatUtil.color(SkyblockCoreConfig.get().getString("chatclear").replace("%player%", p.getDisplayName())));
        }

        return false;
    }
}
