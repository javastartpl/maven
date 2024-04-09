package pl.javastart.jparser.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PageParserTest {

    @Mock
    private HtmlFetcher htmlFetcher;
    @Mock
    private ElementExtractor elementExtractor;
    @InjectMocks
    private PageParser pageParser;

    @Test
    void shouldFindSingleH1() throws IOException {
        final String url = "http://example.com";
        final String[] selectors = {"h1"};
        String html = Files.readString(
                Path.of(PageParserTest.class
                        .getResource("/html/test.html")
                        .getPath()
                )
        );
        when(htmlFetcher.fetch(url)).thenReturn(html);
        Map<String, List<String>> map = Map.of("h1", List.of("Example Domain"));
        when(elementExtractor.extractElements(html, selectors)).thenReturn(map);
        ExtractedElements extractedElements = pageParser.extractElements(url, selectors);
        assertEquals(url, extractedElements.url());
        assertEquals(map, extractedElements.elements());
    }
}
