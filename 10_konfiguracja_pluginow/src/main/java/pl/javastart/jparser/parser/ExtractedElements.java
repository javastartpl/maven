package pl.javastart.jparser.parser;  
  
import java.util.List;  
import java.util.Map;  
  
public record ExtractedElements(String url, Map<String, List<String>> elements) {  }