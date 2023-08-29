package me.verni.listeners;

import me.verni.SkyblockCoreConfig;
import me.verni.SkyblockCorePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CensorListener implements Listener {

    SkyblockCorePlugin plugin;

    public CensorListener(final SkyblockCorePlugin m) {
        this.plugin = m;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String censor = SkyblockCoreConfig.get().getString("censor");
        for (String temp : this.plugin.getConfig().getStringList("Censored Words")) {
            if (e.getMessage().toLowerCase().contains(temp.toLowerCase())) {
                if (p.hasPermission("skyblock.bypasas")) {
                    return;
                }
                final String msg = e.getMessage().toLowerCase().replace(temp.toLowerCase(), censor);
                e.setMessage(msg);
            }
        }
    }
}
