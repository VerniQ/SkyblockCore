package me.verni.commands;


import me.verni.SkyblockCoreConfig;
import me.verni.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoreCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player p = (Player) sender;
            if (p.hasPermission("skyblock.admin")) {
                if (args.length == 0) { // Command issued with no arguments
                    sender.sendMessage(ChatUtil.color("&cWersja: 1.0.0"));
                    return true;
                }

            } else {
                ChatUtil.color("&cNie posiadasz uprawnień!");
            }
            if (args.length >= 1){
                switch (args[0]){
                    case "reload":
                        SkyblockCoreConfig.reload();
                        return true;
                }
            }


        return false;
    }
}
