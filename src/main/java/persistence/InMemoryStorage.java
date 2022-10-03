package persistence;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Basically a wrapper around a HashMap object.
 * When the Server first starts up, it will load from disk persistent records.
 */
public class InMemoryStorage {

    private final Map<String, JSONObject> storage;

    public InMemoryStorage() {
        storage = new HashMap<>();
    }

    public JSONObject get(String key) {
        return storage.get(key);
    }

    public void put(String key, JSONObject val) {
        storage.put(key, val);
    }
}
