package persistence;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TestDiskReadWriter {
    public static void main(String[] args) throws IOException {
        InMemoryStorage storage = new InMemoryStorage();
        JSONObject obj1 = new JSONObject();
        obj1.put("key1", "val1");
        obj1.put("key2", List.of(1, 2, 3));
        storage.put("obj1", obj1);
        DiskReadWriter.writeToDisk(storage, "data.json");
    }
}
