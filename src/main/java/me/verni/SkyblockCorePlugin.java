package me.verni;

import me.verni.commands.AdminChatCommand;
import me.verni.commands.ClearChatCommand;
import me.verni.commands.CoreCommand;
import me.verni.commands.HelpCommand;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class SkyblockCorePlugin extends JavaPlugin {

    FileConfiguration config = getConfig();


    public void onEnable(){


        config.addDefault("ClearInventoryOnIslandDelete", true);
        config.options().copyDefaults(true);
        saveConfig();

        ArrayList<String> help = new ArrayList<String>();
        help.add("&cThis is default message");

        SkyblockCoreConfig.setup();
        SkyblockCoreConfig.get().addDefault("HelpCommand", help);
        SkyblockCoreConfig.get().options().copyDefaults(true);
        SkyblockCoreConfig.save();

        this.getCommand("pomoc").setExecutor(new HelpCommand());
        this.getCommand("cc").setExecutor(new ClearChatCommand());
        this.getCommand("core").setExecutor(new CoreCommand());
        this.getCommand("a").setExecutor(new AdminChatCommand());



    }

    public void onDisable(){

    }



}