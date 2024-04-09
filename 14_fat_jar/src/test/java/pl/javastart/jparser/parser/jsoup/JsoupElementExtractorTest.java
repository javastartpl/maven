package pl.javastart.jparser.parser.jsoup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JsoupElementExtractorTest {

    private final JsoupElementExtractor elementExtractor = new JsoupElementExtractor();
    private static String html;

    @BeforeAll
    static void loadTestFile() throws IOException {
        html = Files.readString(
                Path.of(JsoupElementExtractorTest.class
                        .getResource("/html/test.html")
                        .getPath()
                )
        );
    }

    @Test
    void shouldFindTwoH2AndSingleH1() {
        Map<String, List<String>> elements = elementExtractor.extractElements(html, "h1", "h2");
        assertEquals(2, elements.get("h2").size());
        assertEquals(1, elements.get("h1").size());
    }

    @Test
    void shouldNotFindH3() {
        Map<String, List<String>> elements = elementExtractor.extractElements(html, "h3");
        assertTrue(elements.get("h3").isEmpty());
    }

    @Test
    void shouldBeEmptyForEmptySelectors() {
        Map<String, List<String>> elements = elementExtractor.extractElements(html);
        assertTrue(elements.isEmpty());
    }
}
