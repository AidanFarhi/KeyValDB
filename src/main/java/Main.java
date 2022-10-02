import com.sun.net.httpserver.HttpServer;
import handlers.GetHandler;
import persistence.InMemStorage;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = args.length == 1 ? Integer.parseInt(args[0]) : 8000;
        InMemStorage storage = new InMemStorage();
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/v1/key-val-db/get", new GetHandler(storage));
        server.setExecutor(null);
        server.start();
    }
}
