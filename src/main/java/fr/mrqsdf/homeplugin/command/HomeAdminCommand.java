package fr.mrqsdf.homeplugin.command;

import fr.mrqsdf.homeplugin.gui.HomeGui;
import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeAdminCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (args.length != 1){
                player.sendMessage("Usage: /homeadmin <player>");
                return false;
            }
            String playerName = args[0];

            if (!PlayerData.playerHomes.containsKey(Bukkit.getPlayer(playerName).getUniqueId())){
                player.sendMessage("This player does not exist");
                return false;
            }
            HomeGui.openGui(player, Bukkit.getPlayer(playerName));
        }
        return false;
    }

}
