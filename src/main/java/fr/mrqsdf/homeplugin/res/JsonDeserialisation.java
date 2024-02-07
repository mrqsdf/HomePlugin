package fr.mrqsdf.homeplugin.res;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JsonDeserialisation implements JsonDeserializer<Map<UUID, List<Home>>> {

    @Override
    public Map<UUID, List<Home>> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Map<UUID, List<Home>> map = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()){
            map.put(UUID.fromString(entry.getKey()), context.deserialize(entry.getValue(), List.class));
        }
        return map;
    }

}
