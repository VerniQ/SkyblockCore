package me.verni.commands;

import me.verni.SkyblockCoreConfig;
import me.verni.util.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SvipCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        ArrayList<String> temp = (ArrayList<String>) SkyblockCoreConfig.get().getStringList("HelpCommandSvip");
        for (int i=0; i<temp.size(); i++){
            p.sendMessage(ChatUtil.color(temp.get(i).replaceAll("%player%", p.getName())));
        }
        return false;
    }

}
