package fr.mrqsdf.homeplugin.event.listener;

import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (!PlayerData.playerHomes.containsKey(player.getUniqueId())){
            PlayerData.playerHomes.put(player.getUniqueId(), new ArrayList<>());
        }
    }

}
