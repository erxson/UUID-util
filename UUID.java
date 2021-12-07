import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.net.URL;

public class UUID {
    public static java.util.UUID getUUID(String name) {
        String uuid = "";
        if (Bukkit.getOnlineMode()) {
            String url = "https://api.mojang.com/users/profiles/minecraft/"+name;
            try {
                @SuppressWarnings("deprecation")
                String UUIDJson = IOUtils.toString(new URL(url));
                JSONObject UUIDObject = (JSONObject) JSONValue.parseWithException(UUIDJson);
                return (java.util.UUID) UUIDObject.get("id");
            } catch (IOException | ParseException e) {}
        } else {
            String url = "http://tools.glowingmines.eu/convertor/nick/"+name;
            try {
                @SuppressWarnings("deprecation")
                String UUIDJson = IOUtils.toString(new URL(url));
                JSONObject UUIDObject = (JSONObject) JSONValue.parseWithException(UUIDJson);
                return (java.util.UUID) UUIDObject.get("offlineuuid");
            } catch (IOException | ParseException e) {}
        }
        return java.util.UUID.fromString(uuid);
    }
}
