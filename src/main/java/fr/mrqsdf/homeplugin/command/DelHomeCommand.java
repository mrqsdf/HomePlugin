package fr.mrqsdf.homeplugin.command;

import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelHomeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (args.length != 1){
                player.sendMessage("Usage: /delhome <home>");
                return false;
            }
            String homeName = args[0];
            if (!PlayerData.playerHomes.get(player.getUniqueId()).removeIf(home -> home.name.equals(homeName))){
                player.sendMessage("This home does not exist");
                return false;
            }
            player.sendMessage("Home deleted");
        }
        return false;
    }

}
