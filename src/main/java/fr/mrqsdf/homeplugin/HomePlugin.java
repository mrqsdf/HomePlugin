package fr.mrqsdf.homeplugin;

import fr.mrqsdf.homeplugin.command.*;
import fr.mrqsdf.homeplugin.event.listener.PlayerJoinListener;
import fr.mrqsdf.homeplugin.gui.HomeGui;
import fr.mrqsdf.homeplugin.res.JsonGestion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HomePlugin extends JavaPlugin{
    public static HomePlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        JsonGestion.loadData();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new HomeGui(), this);

        Bukkit.getPluginCommand("home").setExecutor(new HomeCommand());
        Bukkit.getPluginCommand("sethome").setExecutor(new SetHomeCommand());
        Bukkit.getPluginCommand("delhome").setExecutor(new DelHomeCommand());
        Bukkit.getPluginCommand("homeadmin").setExecutor(new HomeAdminCommand());
        Bukkit.getPluginCommand("sethomeadmin").setExecutor(new SetHomeAdminCommand());
        Bukkit.getPluginCommand("delhomeadmin").setExecutor(new DelHomeAdminCommand());
        getLogger().info("HomePlugin has been enabled");
    }

    @Override
    public void onDisable() {
        JsonGestion.saveData();
        getLogger().info("HomePlugin has been disabled");
    }

}
