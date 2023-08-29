package me.verni.listeners;

import me.verni.SkyblockCoreConfig;
import me.verni.SkyblockCorePlugin;
import me.verni.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatStatusListener implements Listener {

    SkyblockCorePlugin plugin;
    public ChatStatusListener(final SkyblockCorePlugin m) {
        this.plugin = m;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(!(e.getPlayer() instanceof Player))return;
        if(SkyblockCorePlugin.ChatStatus==true) return;
        if(e.getPlayer().hasPermission("skyblock.bypass")) return;
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatUtil.color(SkyblockCoreConfig.get().getString("chatdisabled")));
    }
}
