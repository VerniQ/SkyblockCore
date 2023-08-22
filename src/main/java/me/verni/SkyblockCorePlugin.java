package me.verni;

import me.verni.commands.ClearChatCommand;
import me.verni.commands.HelpCommand;
import org.bukkit.configuration.file.FileConfiguration;
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
        this.getCommand("core").setExecutor(new ClearChatCommand());

    }

    public void onDisable(){

    }

}