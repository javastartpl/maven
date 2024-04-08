package pl.javastart.jparser.parser;    
    
import java.util.List;    
import java.util.Map;    
    
public class PageParser {    
    private final ElementExtractor elementExtractor;    
    private final HtmlFetcher htmlFetcher;    
    
    public PageParser(ElementExtractor elementExtractor, HtmlFetcher htmlFetcher) {    
        this.elementExtractor = elementExtractor;    
        this.htmlFetcher = htmlFetcher;    
    }    
    
    public ExtractedElements extractElements(String url, String... selectors) {    
        String html = htmlFetcher.fetch(url);    
        Map<String, List<String>> extractedElements = elementExtractor.extractElements(html, selectors);    
        return new ExtractedElements(url, extractedElements);    
    }    
}