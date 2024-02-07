package fr.mrqsdf.homeplugin.res;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class GuiData {

    public static String homeGuiName = "HomeGui : ";
    public static Map<Integer, ItemStack> homeItems = new HashMap<>(){{
        for (int i = 0; i < 9; i++){
            put(i, itemStack());
        }
        put(9, itemStack());
        put(17, itemStack());
        put(18, itemStack());
        put(26, itemStack());
        put(27, itemStack());
        put(35, itemStack());
        put(36, itemStack());
        put(44, itemStack());
        for (int i = 45; i < 54; i++){
            put(i, itemStack());
        }
    }};



    public static ItemStack itemStack(){
        ItemStack itemStack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getHomeItem(int index){
        return homeItems.get(index);
    }

}
