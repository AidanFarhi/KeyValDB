package persistence;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes and reads InMemoryStorage contents to and from Disk.
 */
public class DiskReadWriter {

    public static void writeToDisk(InMemoryStorage storage, String jsonFileName) throws IOException {
        // FileWriter jsonFileWriter = new FileWriter(jsonFileName);
        Map<String, JSONObject> data = storage.getStorage();
        for (String key : data.keySet()) {
            System.out.println(key);
        }
    }
}
