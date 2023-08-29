package me.verni.listeners;

import me.verni.SkyblockCoreConfig;
import me.verni.SkyblockCorePlugin;
import me.verni.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;


public class CooldownListener implements Listener {


    private HashMap<Player, Long> spam;
    private SkyblockCorePlugin plugin;

    public CooldownListener(final SkyblockCorePlugin m) {
        this.plugin = m;
        this.spam = new HashMap<>();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (SkyblockCorePlugin.ChatStatus ==false) return;
        if (!p.hasPermission("skyblock.cooldown")) {
            if (this.spam.containsKey(p)) {
                if (this.spam.get(p) > System.currentTimeMillis()) {
                    int temp = this.plugin.getConfig().getInt("chatcooldown");
                    p.sendMessage(ChatUtil.hex("&#", "", SkyblockCoreConfig.get().getString("prefix")) + ChatUtil.color(" " + SkyblockCoreConfig.get().getString("chatcooldownmsg").replace("%cooldown%", Integer.toString(this.plugin.getConfig().getInt("chatcooldown")))));
                    e.setCancelled(true);
                } else {
                    this.spam.put(p, System.currentTimeMillis() + this.plugin.getConfig().getInt("chatcooldown") * 1000L);
                }
            } else {
                this.spam.put(p, System.currentTimeMillis() + this.plugin.getConfig().getInt("chatcooldown") * 1000L);
            }
        }
    }
}


