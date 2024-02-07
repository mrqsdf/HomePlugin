package fr.mrqsdf.homeplugin.command;

import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelHomeAdminCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (args.length != 2){
                player.sendMessage("Usage: /delhomeadmin <player> <home>");
                return false;
            }
            String playerName = args[0];
            String homeName = args[1];
            if (PlayerData.playerHomes.get(Bukkit.getPlayer(playerName).getUniqueId()) == null){
                player.sendMessage("This player does not exist");
                return false;
            }
            if (!PlayerData.playerHomes.get(Bukkit.getPlayer(playerName).getUniqueId()).removeIf(home -> home.name.equals(homeName))){
                player.sendMessage("This home does not exist");
                return false;
            }
            player.sendMessage("Home deleted");
        }
        return false;
    }

}
