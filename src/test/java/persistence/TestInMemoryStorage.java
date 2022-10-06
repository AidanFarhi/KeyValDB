package persistence;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestInMemoryStorage {

    private InMemoryStorage storage;

    @Before
    public void setUp() {
        storage = new InMemoryStorage();
        JSONObject obj1 = new JSONObject();
        obj1.put("jsonKey1", "jsonVal1");
        storage.put("key1", obj1);
    }

    @Test
    public void testGet() {
        JSONObject obj = storage.get("key1");
        assertEquals(obj.get("jsonKey1"), "jsonVal1");
    }

    @Test
    public void testPut() {
        JSONObject newObject = new JSONObject();
        newObject.put("jsonKey2", "jsonVal2");
        storage.put("key2", newObject);
        assertEquals(storage.get("key2").get("jsonKey2"), "jsonVal2");
    }
}
