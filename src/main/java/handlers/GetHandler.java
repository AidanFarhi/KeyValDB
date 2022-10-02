package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import persistence.InMemStorage;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Handler for retrieving a single record for a from InMemoryStorage.
 */
public class GetHandler implements HttpHandler {

    private final InMemStorage storage;

    public GetHandler(InMemStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, 0);
        OutputStream out = exchange.getResponseBody();
        String key = parseQueryParameter(query);
        JSONObject obj = storage.get(key) == null ? new JSONObject() : storage.get(key);
        out.write(obj.toString().getBytes(StandardCharsets.UTF_8));
        out.close();
    }

    private String parseQueryParameter(String queryParams) {
        String[] splitParams = queryParams.split("=");
        return splitParams[1];
    }
}
