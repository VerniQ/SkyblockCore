package me.verni;

import me.verni.commands.*;
import me.verni.listeners.CensorListener;
import me.verni.listeners.ChatStatusListener;
import me.verni.listeners.CooldownListener;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class SkyblockCorePlugin extends JavaPlugin {

    FileConfiguration config = getConfig();
    public static boolean ChatStatus;


    public void onEnable(){

        ChatStatus = true;




        ArrayList<String> help = new ArrayList<String>();
        help.add("&cThis is default message");

        ArrayList<String> blacklist = new ArrayList<>();
        blacklist.add("blocked word");


        config.addDefault("ClearInventoryOnIslandDelete", true);
        config.addDefault("Censored Words", blacklist);
        config.addDefault("chatcooldown", 3);
        config.options().copyDefaults(true);
        saveConfig();


        SkyblockCoreConfig.setup();
        SkyblockCoreConfig.get().addDefault("HelpCommand", help);
        SkyblockCoreConfig.get().addDefault("prefix", "&#DAF7A6ᴅᴏᴜʙʟᴇᴄʀᴀғᴛ");
        SkyblockCoreConfig.get().addDefault("chaton", "&7Chat został &awłączony &7przez: &e%player%");
        SkyblockCoreConfig.get().addDefault("chatoff", "&7Chat został &cwyłączony &7przez: &e%player%");
        SkyblockCoreConfig.get().addDefault("chatclear", "&7Chat został &awyczyszczony &7przez: &e%player%");
        SkyblockCoreConfig.get().addDefault("chatdisabled", "&7Chat jest obecnie &cwyłączony!");
        SkyblockCoreConfig.get().addDefault("chatcooldownmsg", "&cMusisz poczekać &e%cooldown% sekund &czanim napiszesz kolejną wiadomość!");
        SkyblockCoreConfig.get().addDefault("isenabled", "&cChat jest już &awłączony!");
        SkyblockCoreConfig.get().addDefault("isdisabled", "&cChat jest już wyłączony!");
        SkyblockCoreConfig.get().addDefault("noperms", "&cNie posiadasz uprawnień!");
        SkyblockCoreConfig.get().addDefault("censor", "***");
        SkyblockCoreConfig.get().options().copyDefaults(true);
        SkyblockCoreConfig.save();

        this.getCommand("pomoc").setExecutor(new HelpCommand());
        this.getCommand("cc").setExecutor(new ClearChatCommand());
        this.getCommand("core").setExecutor(new CoreCommand());
        this.getCommand("a").setExecutor(new AdminChatCommand());
        this.getCommand("chat").setExecutor(new ChatManagerCommand());


        getServer().getPluginManager().registerEvents(new CensorListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatStatusListener(this), this);
        getServer().getPluginManager().registerEvents(new CooldownListener(this), this);




    }

    public void onDisable(){

    }



}