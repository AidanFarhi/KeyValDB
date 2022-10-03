package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import persistence.InMemoryStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


/**
 * Handler for putting a single record into InMemoryStorage.
 */
public class PutSingleRecordHandler implements HttpHandler {

    private final InMemoryStorage storage;

    public PutSingleRecordHandler(InMemoryStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
                .lines()
                .collect(Collectors.joining("\n"));
        JSONObject bodyAsJSON = new JSONObject(body);
        String key = bodyAsJSON.keys().next();
        storage.put(key, bodyAsJSON.getJSONObject(key));
        exchange.sendResponseHeaders(200, 0);
        exchange.close();
    }
}
