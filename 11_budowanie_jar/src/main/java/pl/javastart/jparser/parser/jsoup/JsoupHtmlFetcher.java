package pl.javastart.jparser.parser.jsoup;  
  
import java.io.IOException;  
import java.io.UncheckedIOException;

import org.jsoup.Jsoup;

import pl.javastart.jparser.parser.HtmlFetcher;  
  
public class JsoupHtmlFetcher implements HtmlFetcher {  
    @Override  
    public String fetch(String url) {  
        try {  
            return Jsoup.connect(url).get().html();  
        } catch (IOException e) {  
            throw new UncheckedIOException(e);  
        }  
    }  
}