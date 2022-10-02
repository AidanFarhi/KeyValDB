package persistence;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Basically a wrapper around a HashMap object.
 * When the Server first starts up, it will load from disk persistent records.
 */
public class InMemStorage {

    private final Map<String, JSONObject> storage;

    public InMemStorage() {
        storage = new HashMap<>();
        // dummy data
        JSONObject obj = new JSONObject();
        obj.put("foo", "bar");
        obj.put("baz", 100);
        JSONObject obj2 = new JSONObject();
        obj2.put("list", List.of("One", "Two", "Three"));
        obj2.put("number", 10101);
        storage.put("data", obj);
        storage.put("data2", obj2);
    }

    public JSONObject get(String key) {
        return storage.get(key);
    }

    public void put(String key, JSONObject val) {
        storage.put(key, val);
    }
}
