package fr.mrqsdf.homeplugin.command;

import fr.mrqsdf.homeplugin.gui.HomeGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (args.length != 0){
                player.sendMessage("Usage: /home");
                return false;
            }
            HomeGui.openGui(player);

        }
        return false;
    }

}
