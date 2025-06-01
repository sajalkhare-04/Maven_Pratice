import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

/**
 * Simple HTTP Server Application
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            // Bind server to 0.0.0.0:8080
            HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 9090), 0);
            server.createContext("/", new RootHandler());
            server.setExecutor(null); // Default executor
            server.start();

            LOGGER.info("Server started at http://0.0.0.0:9090");
            System.out.println("Server running... Visit http://localhost:9090");
        } catch (IOException e) {
            LOGGER.severe("Failed to start server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Define HTTP handler
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello Everyone";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
