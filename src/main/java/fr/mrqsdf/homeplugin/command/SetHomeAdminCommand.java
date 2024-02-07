package fr.mrqsdf.homeplugin.command;

import fr.mrqsdf.homeplugin.res.Home;
import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SetHomeAdminCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (args.length != 2){
                player.sendMessage("Usage: /sethomeadmin <player> <name>");
                return false;
            }
            String playerName = args[0];
            if (Bukkit.getPlayer(playerName) == null){
                player.sendMessage("This player does not exist");
                return false;
            }
            Home home = new Home(args[1],Bukkit.getPlayer(playerName).getLocation().getX(), Bukkit.getPlayer(playerName).getLocation().getY(), Bukkit.getPlayer(playerName).getLocation().getZ(), Bukkit.getPlayer(playerName).getLocation().getWorld().getName(), Bukkit.getPlayer(playerName).getUniqueId().toString());
            PlayerData.playerHomes.get(Bukkit.getPlayer(playerName).getUniqueId()).add(home);
            player.sendMessage("Home set");
        }
        return false;
    }

}
