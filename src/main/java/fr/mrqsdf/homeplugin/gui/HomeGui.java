package fr.mrqsdf.homeplugin.gui;

import fr.mrqsdf.homeplugin.HomePlugin;
import fr.mrqsdf.homeplugin.res.GuiData;
import fr.mrqsdf.homeplugin.res.Home;
import fr.mrqsdf.homeplugin.res.HomeDataType;
import fr.mrqsdf.homeplugin.res.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class HomeGui implements Listener {

    public static void openGui(Player player){
        Inventory gui = player.getServer().createInventory(null, 54, GuiData.homeGuiName + player.getName());
        List<Home> homes = PlayerData.playerHomes.get(player.getUniqueId());
        int length = homes.size();
        int index = 0;
        for (int i = 10; i < 44; i++){
            if (index == length){
                break;
            }
            if (!(i % 9 == 0 || i % 9 == 8)){
                ItemStack item = new ItemStack(Material.ACACIA_SIGN);
                ItemMeta itemMeta = item.getItemMeta();
                Home home = homes.get(index);
                itemMeta.setDisplayName(home.name);
                List<String> lore = new ArrayList<>();
                itemMeta.getPersistentDataContainer().set(new NamespacedKey(HomePlugin.instance, "home"), new HomeDataType(), home);
                lore.add("X: " + home.x);
                lore.add("Y: " + home.y);
                lore.add("Z: " + home.z);
                lore.add("World: " + home.world);
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                gui.setItem(i, item);
                index++;
            }
        }
        player.openInventory(gui);
    }
    public static void openGui(Player player, Player target){
        Inventory gui = player.getServer().createInventory(null, 54, GuiData.homeGuiName + target.getName());
        List<Home> homes = PlayerData.playerHomes.get(target.getUniqueId());
        int length = homes.size();
        int index = 0;
        for (int i = 10; i < 44; i++){
            if (index == length){
                break;
            }
            if (!(i % 9 == 0 || i % 9 == 8)){
                ItemStack item = new ItemStack(Material.ACACIA_SIGN);
                ItemMeta itemMeta = item.getItemMeta();
                Home home = homes.get(index);
                itemMeta.setDisplayName(home.name);
                List<String> lore = new ArrayList<>();
                itemMeta.getPersistentDataContainer().set(new NamespacedKey(HomePlugin.instance, "home"), new HomeDataType(), home);
                lore.add("X: " + home.x);
                lore.add("Y: " + home.y);
                lore.add("Z: " + home.z);
                lore.add("World: " + home.world);
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                gui.setItem(i, item);
                index++;
            }
        }
        player.openInventory(gui);
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();
        if (clickedInventory != null && clickedInventory.equals(player.getOpenInventory().getTopInventory())){
            ItemStack item = event.getCurrentItem();
            if (item != null && item.getType() != Material.AIR){
                if (item.getType() == Material.ACACIA_SIGN){
                    Home home = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HomePlugin.instance, "home"), new HomeDataType());
                    Location location = new Location(Bukkit.getWorld(home.world), home.x, home.y, home.z);
                    player.teleport(location);
                    player.closeInventory();
                }
            }
        }
    }


}
