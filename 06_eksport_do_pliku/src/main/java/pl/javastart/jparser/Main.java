package pl.javastart.jparser;

import java.util.List;
import java.util.Map;

import pl.javastart.jparser.io.export.DataExporter;
import pl.javastart.jparser.parser.ExtractedElements;
import pl.javastart.jparser.parser.PageParser;
import pl.javastart.jparser.parser.jsoup.JsoupElementExtractor;
import pl.javastart.jparser.parser.jsoup.JsoupHtmlFetcher;

public class Main {

    public static void main(String[] args) {
        JsoupHtmlFetcher jsoupHtmlFetcher = new JsoupHtmlFetcher();
        JsoupElementExtractor jsoupElementExtractor = new JsoupElementExtractor();
        PageParser pageParser = new PageParser(jsoupElementExtractor, jsoupHtmlFetcher);
        final String url = "https://example.com";
        System.out.println("Connecting to " + url);
        ExtractedElements extractedElements = pageParser.extractElements(url, "h1", "p");
        System.out.println("Extracting elements from " + url + " completed.");
        System.out.println("Analyzed selectors: " + extractedElements.elements().keySet());
        System.out.println("Extracted elements:");
        for (Map.Entry<String, List<String>> entry : extractedElements.elements().entrySet()) {
            List<String> elements = entry.getValue();
            if (!elements.isEmpty()) {
                System.out.println(entry.getKey());
                for (int i = 0; i < elements.size(); i++) {
                    System.out.println(" " + i + ": " + elements.get(i));
                }
            }
        }
        String fileName = "output.csv";
        DataExporter.save(extractedElements, fileName);
        System.out.println("Data exported to file " + fileName);
    }
}
