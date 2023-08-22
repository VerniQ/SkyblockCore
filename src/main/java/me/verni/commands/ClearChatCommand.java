package me.verni.commands;

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
            for(int i=0; i<100; i++)
            {
                Bukkit.broadcastMessage("");
            }

        return false;
    }
}
