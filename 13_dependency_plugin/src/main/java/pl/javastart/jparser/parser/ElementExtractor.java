package pl.javastart.jparser.parser;  
  
import java.util.List;  
import java.util.Map;  
  
public interface ElementExtractor {  
    Map<String, List<String>> extractElements(String html, String[] selectors);  
}