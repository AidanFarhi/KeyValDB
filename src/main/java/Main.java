import com.sun.net.httpserver.HttpServer;
import handlers.GetSingleRecordHandler;
import handlers.PutSingleRecordHandler;
import persistence.InMemoryStorage;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = args.length == 1 ? Integer.parseInt(args[0]) : 8000;
        System.out.println("Starting server on localhost: " + port);
        InMemoryStorage storage = new InMemoryStorage();
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        server.createContext("/api/v1/key-val-db/get", new GetSingleRecordHandler(storage));
        server.createContext("/api/v1/key-val-db/put", new PutSingleRecordHandler(storage));
        server.setExecutor(null);
        server.start();
    }
}
