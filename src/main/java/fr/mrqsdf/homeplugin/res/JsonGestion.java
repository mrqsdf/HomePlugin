package fr.mrqsdf.homeplugin.res;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.mrqsdf.homeplugin.HomePlugin;
import org.apache.logging.log4j.core.util.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JsonGestion {

    public static void saveData(){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            FileWriter writer = new FileWriter(HomePlugin.instance.getDataFolder() + "/playerHomes.json");
            writer.write(gson.toJson(PlayerData.playerHomes));
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadData(){
        Gson gson = new Gson();
        File file = new File(HomePlugin.instance.getDataFolder() + "/");
        if (!file.exists()){
            file.mkdirs();
        }
        File f = new File(HomePlugin.instance.getDataFolder() + "/playerHomes.json");
        if (!f.exists()){
            System.out.println("File not Found");
        }

        try {
            FileReader fileReader = new FileReader(HomePlugin.instance.getDataFolder() + "/playerHomes.json");
            Object o = JsonParser.parseReader(fileReader);
            JsonObject jsonObject = (JsonObject) o;
            String json = jsonObject.toString();
            Type empMapType = new TypeToken<Map<UUID, List<Home>>>() {}.getType();
            PlayerData.playerHomes = gson.fromJson(json, empMapType);
        } catch (Exception e){
            HomePlugin.instance.getLogger().warning("No data found, creating a new file");
        }
    }

}
