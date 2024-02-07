package fr.mrqsdf.homeplugin.command;

import fr.mrqsdf.homeplugin.res.Home;
import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (strings.length == 1){
                String name = strings[0];
                new Home(name,player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getWorld().getName(), player.getUniqueId().toString());
                PlayerData.playerHomes.get(player.getUniqueId()).add(new Home(name,player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getWorld().getName(), player.getUniqueId().toString()));
                return true;
            } else {
                player.sendMessage("Usage: /sethome <name>");
            }
        }
        return false;
    }
}
