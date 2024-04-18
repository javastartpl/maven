import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

class Application {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(8080);
        Path path = Path.of("/opt/data");
        HttpServer server = SimpleFileServer.createFileServer(
                address, path, SimpleFileServer.OutputLevel.INFO
        );
        server.start();
    }
}
