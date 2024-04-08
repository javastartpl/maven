package pl.javastart;  
  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.select.Elements;  
  
import java.io.IOException;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        String h1 = getH1("http://example.com");  
        System.out.println(h1);  
    }  
      
    static String getH1(String website) throws IOException {  
        Document document = Jsoup.connect(website).get();  
        Elements elements = document.select("h1");  
        return elements.getFirst().text();  
    }  
}