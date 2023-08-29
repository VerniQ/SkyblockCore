package me.verni.commands;

import me.verni.SkyblockCoreConfig;
import me.verni.SkyblockCorePlugin;
import me.verni.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatManagerCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) return false;
            Player p = (Player) sender;
            if (p.hasPermission("skyblock.admin")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatUtil.color("&cWersja: 1.0.0"));
                    return true;
                }


                if (args.length >= 1) {
                    switch (args[0]) {
                        case "on":
                            if (SkyblockCorePlugin.ChatStatus == true) {
                                p.sendMessage(ChatUtil.hex("&#", "", SkyblockCoreConfig.get().getString("prefix")) + " " + ChatUtil.color(SkyblockCoreConfig.get().getString("isenabled")));
                                return true;
                            }
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendMessage(ChatUtil.hex("&#", "", SkyblockCoreConfig.get().getString("prefix")) + ChatUtil.color(" " + SkyblockCoreConfig.get().getString("chaton").replace("%player%", p.getName())));
                            }
                            SkyblockCorePlugin.ChatStatus = true;

                            return true;
                        case "off":
                            if (SkyblockCorePlugin.ChatStatus == false) {
                                p.sendMessage(ChatUtil.hex("&#", "", SkyblockCoreConfig.get().getString("prefix")) + " " +  ChatUtil.color(SkyblockCoreConfig.get().getString("isdisabled")));
                                return true;
                            }
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendMessage(ChatUtil.hex("&#", "", SkyblockCoreConfig.get().getString("prefix")) + ChatUtil.color(" " + SkyblockCoreConfig.get().getString("chatoff").replace("%player%", p.getName())));
                            }
                            SkyblockCorePlugin.ChatStatus = false;

                            return true;


                    }
                }
            }else {
                p.sendMessage(ChatUtil.color(SkyblockCoreConfig.get().getString("noperms")));
            }


            return false;
        }

}
