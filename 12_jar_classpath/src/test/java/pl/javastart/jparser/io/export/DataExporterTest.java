package pl.javastart.jparser.io.export;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import pl.javastart.jparser.parser.ExtractedElements;

class DataExporterTest {

    @TempDir
    private Path tempDir;

    @Test
    void shouldExportDataWhenExtractedElementsNotEmpty() throws IOException {
        Path outputFilePath = tempDir.resolve(Path.of("outputFile.csv"));
        ExtractedElements extractedElements = new ExtractedElements("http://example.com", Map.of(
                "h1", List.of("first heading", "second heading"),
                "p", List.of("first paragraph", "second paragraph")
        ));
        DataExporter.save(extractedElements, outputFilePath.toString());
        String outputFileContent = Files.readString(outputFilePath);
        assertTrue(outputFileContent.contains("h1;first heading"));
        assertTrue(outputFileContent.contains("p;first paragraph"));
    }

    @Test
    void shouldOverrideFileIfExists() throws IOException {
        Path outputFilePath = tempDir.resolve(Path.of("outputFile.csv"));
        Files.writeString(outputFilePath, "something");
        ExtractedElements extractedElements = new ExtractedElements("http://example.com", Map.of(
                "h1", List.of("hello")
        ));
        DataExporter.save(extractedElements, outputFilePath.toString());
        String outputFileContent = Files.readString(outputFilePath);
        assertFalse(outputFileContent.contains("something"));
        assertTrue(outputFileContent.contains("http://example.com"));
        assertTrue(outputFileContent.contains("h1;hello"));
    }
}
