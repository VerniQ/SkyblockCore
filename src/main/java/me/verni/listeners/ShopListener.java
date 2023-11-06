package me.verni.listeners;

import me.verni.SkyblockCorePlugin;
import me.verni.util.ChatUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class ShopListener implements Listener {


    public ShopListener(SkyblockCorePlugin skyblockCorePlugin) {
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        String name = p.getOpenInventory().getTitle();

        if (name.equals(ChatUtil.hex("&", "", name))){

            if (e.getRawSlot() == 40) {
                p.performCommand("spawnershop");
                e.setCancelled(true);
            }
        }

    }
}
