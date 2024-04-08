package pl.javastart.jparser.io.export;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import pl.javastart.jparser.parser.ExtractedElements;

public class DataExporter {

    public static void save(ExtractedElements data, String fileName) {
        Path filePath = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write("Elements extracted from " + data.url());
            writer.newLine();
            for (Map.Entry<String, List<String>> entry : data.elements().entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    writer.write(key + ";" + value);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
