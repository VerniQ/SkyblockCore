package me.verni.systems;

import me.verni.SkyblockCoreConfig;
import me.verni.SkyblockCorePlugin;
import me.verni.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class AutoMessageSystem {
    private static SkyblockCorePlugin plugin;

    public AutoMessageSystem(final SkyblockCorePlugin m) {
        this.plugin = m;
    }

    public static void start() {
        new BukkitRunnable() {
                int i=0;
                List<String> messages = SkyblockCoreConfig.get().getStringList("AutoMessage");
                String prefix = SkyblockCoreConfig.get().getString("prefix");
                public void run(){
                    if(i<messages.size()){
                        for(Player player: Bukkit.getOnlinePlayers()){
                            player.sendMessage(ChatUtil.hex("&#", "", prefix) + " " + ChatUtil.color(messages.get(i)));
                        }
                        i++;
                    }else{
                        i=0;
                    }
                }
        }.runTaskTimer(plugin, 20L * plugin.getConfig().getInt("automsgcooldown"), 20L * plugin.getConfig().getInt("automsgcooldown"));
    }
}
