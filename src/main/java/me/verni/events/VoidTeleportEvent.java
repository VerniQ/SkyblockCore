package me.verni.events;

import me.verni.SkyblockCorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class VoidTeleportEvent implements Listener {

    public VoidTeleportEvent(SkyblockCorePlugin skyblockCorePlugin) {
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(!(e.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase("world"))) return;
        Player p = e.getPlayer();
        if(p.getLocation().getBlockY()<40) Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + p.getName());
        }
}
