package pl.javastart.jparser.parser.jsoup;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

class JsoupHtmlFetcherTest {

    private final JsoupHtmlFetcher jsoupHtmlFetcher = new JsoupHtmlFetcher();
    private static HttpServer server;

    @BeforeAll
    static void startServer() {
        InetSocketAddress address = new InetSocketAddress(8090);
        Path path = Path.of(JsoupHtmlFetcherTest.class.getResource("/html").getPath());
        server = SimpleFileServer.createFileServer(address, path, SimpleFileServer.OutputLevel.INFO);
        server.start();
    }

    @Test
    public void shouldFetchHtml() throws IOException {
        String testHtml = Files
                .readString(
                        Path.of(JsoupHtmlFetcherTest.class.getResource("/html/test.html").getPath())
                );
        String parsedTestHtml = Jsoup.parse(testHtml).html();
        String fetchedHtml = jsoupHtmlFetcher
                .fetch("http://localhost:8090/test.html");
        assertEquals(parsedTestHtml, fetchedHtml);
    }

    @Test
    public void shouldThrowUnckechedIOExceptionFor404URL() {
        assertThrows(UncheckedIOException.class,
                () -> jsoupHtmlFetcher.fetch("http://localhost:8090/notexisting.html")
        );
    }

    @AfterAll
    static void stopServer() {
        server.stop(0);
    }
}