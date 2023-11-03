package me.verni;

import me.verni.commands.*;
import me.verni.events.ServerPingEvent;
import me.verni.events.VoidTeleportEvent;
import me.verni.listeners.CensorListener;
import me.verni.listeners.ChatStatusListener;
import me.verni.listeners.CooldownListener;
import me.verni.systems.AutoMessageSystem;
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

        ArrayList<String> helpvip = new ArrayList<String>();
        helpvip.add("&cThis is default message");

        ArrayList<String> helpsvip = new ArrayList<String>();
        helpsvip.add("&cThis is default message");

        ArrayList<String> helpskygod = new ArrayList<String>();
        helpskygod.add("&cThis is default message");

        ArrayList<String> blacklist = new ArrayList<>();
        blacklist.add("blocked word");

        ArrayList<String> automsg = new ArrayList<>();
        automsg.add("&cDefault automsg");


        config.addDefault("ClearInventoryOnIslandDelete", true);
        config.addDefault("Censored Words", blacklist);
        config.addDefault("chatcooldown", 3);
        config.addDefault("automsgcooldown", 45);
        config.addDefault("automsgstatus", false);
        config.options().copyDefaults(true);
        saveConfig();


        SkyblockCoreConfig.setup();
        SkyblockCoreConfig.get().addDefault("HelpCommand", help);
        SkyblockCoreConfig.get().addDefault("HelpCommandVip", helpvip);
        SkyblockCoreConfig.get().addDefault("HelpCommandSvip", helpsvip);
        SkyblockCoreConfig.get().addDefault("HelpCommandSkygod", helpskygod);
        SkyblockCoreConfig.get().addDefault("AutoMessage", automsg);
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
        SkyblockCoreConfig.get().addDefault("discordurl", "unknown discord url");
        SkyblockCoreConfig.get().addDefault("wwwurl", "unknown www url");
        SkyblockCoreConfig.get().addDefault("itemshopurl", "unknown itemshop url");
        SkyblockCoreConfig.get().addDefault("motd", "&cDefault Motd");
        SkyblockCoreConfig.get().options().copyDefaults(true);
        SkyblockCoreConfig.save();

        this.getCommand("pomoc").setExecutor(new HelpCommand());
        this.getCommand("cc").setExecutor(new ClearChatCommand());
        this.getCommand("core").setExecutor(new CoreCommand());
        this.getCommand("a").setExecutor(new AdminChatCommand());
        this.getCommand("chat").setExecutor(new ChatManagerCommand());
        this.getCommand("vip").setExecutor(new VipCommand());
        this.getCommand("svip").setExecutor(new SvipCommand());
        this.getCommand("skygod").setExecutor(new SkygodCommand());
        this.getCommand("linki").setExecutor(new LinkCommand());

        new AutoMessageSystem(this);
        if(config.getBoolean("automsgstatus")) AutoMessageSystem.start();



        getServer().getPluginManager().registerEvents(new CensorListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatStatusListener(this), this);
        getServer().getPluginManager().registerEvents(new CooldownListener(this), this);
        getServer().getPluginManager().registerEvents(new VoidTeleportEvent(this), this);
        getServer().getPluginManager().registerEvents(new ServerPingEvent(this), this);




    }

    public void onDisable(){

    }



}