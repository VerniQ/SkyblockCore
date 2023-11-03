package me.verni.events;

import me.verni.SkyblockCoreConfig;
import me.verni.SkyblockCorePlugin;
import me.verni.util.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPingEvent implements Listener {

    public ServerPingEvent(SkyblockCorePlugin skyblockCorePlugin) {
    }

    @EventHandler(priority= EventPriority.HIGH)
    public void onPing(ServerListPingEvent e){
        e.setMotd(ChatUtil.color(SkyblockCoreConfig.get().getString("motd")));
    }
}
