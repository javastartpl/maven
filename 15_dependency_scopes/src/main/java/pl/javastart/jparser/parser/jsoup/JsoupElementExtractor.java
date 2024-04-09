package pl.javastart.jparser.parser.jsoup;  
  
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;  

import pl.javastart.jparser.parser.ElementExtractor;
  
public class JsoupElementExtractor implements ElementExtractor {  
    @Override  
    public Map<String, List<String>> extractElements(String html, String... selectors) {  
        Document document = Jsoup.parse(html);  
        Map<String, List<String>> result = new HashMap<>();  
        for (String selector : selectors) {  
            Elements elements = document.select(selector);  
            result.put(selector, extractText(elements));  
        }  
        return result;  
    }  
  
    private List<String> extractText(Elements elements) {  
        return elements.stream()  
                .map(Element::text)  
                .collect(Collectors.toList());  
    }  
}