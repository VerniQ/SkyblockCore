package me.verni.commands;

import me.verni.util.ChatUtil;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;


public class AdminChatCommand implements CommandExecutor {
    LuckPerms api = LuckPermsProvider.get();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        if(p.hasPermission("skyblock.adminchat")) {

            for (Player target : Bukkit.getOnlinePlayers()) {
                if(target.hasPermission("skyblock.adminchat")) target.sendMessage(ChatUtil.color("&e&l[&a&lACHAT&e&l] &f" + ChatUtil.hex("&#", "", getDisplayName(p)) + p.getDisplayName() + ": &a" + buildString(args) ));

            }
        }else{
            p.sendMessage(ChatUtil.color("&cNie posiadasz uprawnień!"));
        }
        return false;
    }

    private String buildString(String args[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(args[i]);

        }
        return sb.toString();

    }
    private @NonNull String getDisplayName(Player p){
       return api.getPlayerAdapter(Player.class).getMetaData(p).getPrefix();
    }
}
